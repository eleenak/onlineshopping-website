package com.itn.onlineshoppingfrontend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.itn.onlineshoppingbackend.dao.UserDAO;
import com.itn.onlineshoppingbackend.dto.User;
import com.itn.onlineshoppingfrontend.model.UserModel;

@ControllerAdvice
public class GlobalController {

	@Autowired
	private HttpSession session;

	@Autowired
	private UserDAO userDAO;

	private UserModel userModel = null;

	@ModelAttribute("userModel")
	public UserModel getUserModel() {

		if (session.getAttribute("userModel") == null) {

			// add the user model
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

			User user = userDAO.getByEmail(authentication.getName());
			if (user != null) {
				// create a new UserModel object to pass the user details
				userModel = new UserModel();
				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setFullName(user.getFirstName() + " " + user.getLastName());

				if (userModel.getRole().equals("USER")) {

					// set cart only is user is a buyer
					userModel.setCart(user.getCart());
				}

				// set userModel in the session
				session.setAttribute("user", userModel);
				return userModel;

			}
		}

		return (UserModel) session.getAttribute("userModel");

	}
}
