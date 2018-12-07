package com.itn.onlineshoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.itn.onlineshoppingbackend.dao.CartLineDAO;
import com.itn.onlineshoppingbackend.dao.ProductDAO;
import com.itn.onlineshoppingbackend.dao.UserDAO;
import com.itn.onlineshoppingbackend.dto.Cart;
import com.itn.onlineshoppingbackend.dto.CartLine;
import com.itn.onlineshoppingbackend.dto.Product;
import com.itn.onlineshoppingbackend.dto.User;

public class CartLineTestCase {
	private static AnnotationConfigApplicationContext context;

	private static CartLineDAO cartLineDAO = null;
	private static ProductDAO productDAO = null;
	private static UserDAO userDAO = null;

	private Product product = null;
	private User user = null;
	private Cart cart = null;
	private CartLine cartLine = null;

	@BeforeClass

	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.itn.onlineshoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
		userDAO = (UserDAO) context.getBean("userDAO");
		cartLineDAO = (CartLineDAO) context.getBean("cartLineDAO");

	}

	@Test
	public void testAddNewCartLine() {
		// get user
		user = userDAO.getByEmail("abc@gmail.com");

		// fetch cart
		cart = user.getCart();

		// get the product
		product = productDAO.get(1);

		// create a new cartline
		cartLine = new CartLine();

		cartLine.setBuyingPrice(product.getUnitPrice());

		cartLine.setProductCount(cartLine.getProductCount() + 1);

		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());

		cartLine.setAvailable(true);

		cartLine.setCartId(cart.getId());

		cartLine.setProduct(product);

		assertEquals("Failed to add the cartline", true, cartLineDAO.add(cartLine));

		// update the cart
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() + 1);

		assertEquals("Failed to update the cartline", true, cartLineDAO.updateCart(cart));

	}
}
