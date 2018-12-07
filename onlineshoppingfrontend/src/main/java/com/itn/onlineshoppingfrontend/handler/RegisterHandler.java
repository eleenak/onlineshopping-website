package com.itn.onlineshoppingfrontend.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.itn.onlineshoppingbackend.dao.UserDAO;
import com.itn.onlineshoppingbackend.dto.Address;
import com.itn.onlineshoppingbackend.dto.Cart;
import com.itn.onlineshoppingbackend.dto.User;
import com.itn.onlineshoppingfrontend.model.RegisterModel;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public RegisterModel init() {
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel,User user) {
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel,Address billing) {
		registerModel.setBilling(billing);
	}
	
	public String validateUser(User user,MessageContext error) {
		
		String transitionValue="success";
		//checks if password match
		if(!(user.getPassword().equals(user.getConfirmPassword()))) {
			error.addMessage(new MessageBuilder().error().source("confirmPassword").defaultText("Password doesn't match").build());
			transitionValue="failure";
		}
		//check the uniqueness of email_id
		
		if(userDAO.getByEmail(user.getEmail())!=null) {
			error.addMessage(new MessageBuilder().error().source("email").defaultText("Email already used").build());
			transitionValue="failure";
		}
		
		
		return transitionValue;
	} 
	
	
	public String saveAll(RegisterModel registerModel) {
		String transitionValue="success";
		
		//fetch the user
		User user=registerModel.getUser();
		
		if(user.getRole().equals("USER")) {
			Cart cart=new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		
		//encode the password
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		//save the user
		userDAO.addUser(user);
		
		// get the address
		Address billing=registerModel.getBilling();
		billing.setUserId(user.getId());
		billing.setBilling(true);
		
		//save the address
		userDAO.addAddress(billing);
		return transitionValue;
	}
}
