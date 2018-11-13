package com.itn.onlineshoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.itn.onlineshoppingbackend.dao.UserDAO;
import com.itn.onlineshoppingbackend.dto.Address;
import com.itn.onlineshoppingbackend.dto.Cart;
import com.itn.onlineshoppingbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user=null;
	private Cart cart=null;
	private Address address=null;
	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("com.itn.onlineshoppingbackend");
		context.refresh();
		
		userDAO=(UserDAO) context.getBean("userDAO");
	}
	
/*	
	@Test
	public void testAdd() {
		user=new User();
		user.setFirstName("Eleena");
		user.setLastName("Kayastha");
		user.setEmail("kayasthaeleena@gmail.com");
		user.setContactNumber("98464646446");
		user.setRole("USER");
		user.setPassword("123456");
		
		//add user
		assertEquals("Failed to add user!",true,userDAO.addUser(user));
		
		
		address=new Address();
		address.setAddressLineOne("Thamel");
		address.setAddressLineTwo("Banasthali");
		address.setCity("Kathmandu");
		address.setState("Kathmandu");
		address.setPostalCode("India");
		address.setPostalCode("30001");
		address.setBilling(true);
		
		//link the user with the address using user id
		address.setUserId(user.getId());
		
		
		//add the address
		assertEquals("Failed to add shipping address!",true,userDAO.addAddress(address));
		
		if(user.getRole().equals("USER")) {
			
			//create a cart
			cart=new Cart();
			cart.setUser(user);
			
			//add the cart
			assertEquals("Failed to add cart!",true,userDAO.addCart(cart));
		}
		
	}*/
	
	/*@Test
	public void testAdd() {
		user=new User();
		user.setFirstName("Eleena");
		user.setLastName("Kayastha");
		user.setEmail("kayasthaeleena@gmail.com");
		user.setContactNumber("98464646446");
		user.setRole("USER");
		user.setPassword("123456");
	
		if(user.getRole().equals("USER")) {
			
			//create a cart
			cart=new Cart();
			cart.setUser(user);
			
			//attach cart to the user
			user.setCart(cart);
	
		}
		//add user
				assertEquals("Failed to add user!",true,userDAO.addUser(user));
		
	}*/
	
/*	@Test
	public void testUpdateCart() {
		
		//fetch the user by its email
		user=userDAO.getByEmail("kayasthaeleena@gmail.com");
		
		//get the cart of the user
		cart=user.getCart();
		
		cart.setGrandTotal(60000);
		
		cart.setCartLines(2);
		
		assertEquals("Failed to update the cart",true,userDAO.updateCart(cart));
	}*/
	
	
	/*@Test
	public void testAddAddress() {
		//we need to add an user
		user=new User();
		user.setFirstName("Eleena");
		user.setLastName("Kayastha");
		user.setEmail("kayasthaeleena@gmail.com");
		user.setContactNumber("98464646446");
		user.setRole("USER");
		user.setPassword("123456");
		
		//add user
		assertEquals("Failed to add user!",true,userDAO.addUser(user));

		//we need to add the address
		
		address=new Address();
		address.setAddressLineOne("Dhunge Dhara");
		address.setAddressLineTwo("Banasthali");
		address.setCity("Kathmandu");
		address.setState("Kathmandu");
		address.setPostalCode("Nepal");
		address.setPostalCode("30001");
		address.setBilling(true);
		
		//attach user to the address
		address.setUser(user);
		
		assertEquals("Failed to add address",true,userDAO.addAddress(address));
		
		//we need to add the shipping address
		address=new Address();
		address.setAddressLineOne("Bhagwan Bahal");
		address.setAddressLineTwo("Thamel");
		address.setCity("Kathmandu");
		address.setState("Kathmandu");
		address.setPostalCode("Nepal");
		address.setPostalCode("30001");
		//set shipping to true
		address.setShipping(true);
		
		//attach the user to the address
		address.setUser(user);
		
		assertEquals("Failed to add shipping address!",true,userDAO.addAddress(address));
	}*/
	
/*	@Test
	public void testAddAddress() {
		user=userDAO.getByEmail("kayasthaeleena@gmail.com");
		
		//we need to add the shipping address
				address=new Address();
				address.setAddressLineOne("Dhara Galli");
				address.setAddressLineTwo("Nayabazaar");
				address.setCity("Kathmandu");
				address.setState("Kathmandu");
				address.setPostalCode("Nepal");
				address.setPostalCode("30001");
				//set shipping to true
				address.setShipping(true);
				
				//attach the user to the address
				address.setUser(user);
				
				assertEquals("Failed to add shipping address!",true,userDAO.addAddress(address));
	}*/
	
	@Test
	public void testGetAddress() {
		user=userDAO.getByEmail("kayasthaeleena@gmail.com");
		
		assertEquals("Failed to fetch the list of shipping address and size does not match",2,userDAO.listShippingAddress(user).size());
		assertEquals("Failed to fetch the list of billing address and size does not match","Dhunge Dhara",userDAO.getBillingAddress(user).getAddressLineOne());
	}
}
