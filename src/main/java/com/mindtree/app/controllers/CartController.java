/**
 * 
 */
package com.mindtree.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mindtree.app.model.Cart;
import com.mindtree.app.service.CartService;

/**
 * @author M1016253
 *
 */

@Controller
public class CartController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CartService cartService;

	@Value("${spring.application.name}")
	String appName;

	/**
	 * @param model
	 * @return
	 */
	@GetMapping("/viewCart")
	public String getShoppingCart(ModelMap model) {
		List<Cart> cartItems = new ArrayList<>();
		cartItems = cartService.viewProductFromCart();
		if (cartItems.size() == 0) {
			model.put("cartItems", true);
			model.put("appName", appName);
			model.put("errMsg", "Cart is empty !! Please add items in the cart.");
		}
		model.put("cartItems", cartItems);
		logger.info("Cart is available with items: {}" + cartItems);

		return "view_cart";
	}

	/**
	 * @param productId
	 * @param quantity
	 * @param model
	 * @return
	 */
	@GetMapping("/update/{productId}/{quantity}")
	public String updateCart(@PathVariable Long productId, @PathVariable int quantity, ModelMap model) {
		cartService.updateProductInCart(productId, quantity);
		logger.info("Cart is updated for item :{}" + productId);
		return "redirect:/viewCart";
	}

	/**
	 * @param productId
	 * @param model
	 * @return
	 */
	@GetMapping("/remove/{productId}")
	public String deletProductFromCart(@PathVariable Long productId, ModelMap model) {
		cartService.removeProductFromCart(productId);
		logger.info("Item deleted from Cart :{}" + productId);
		return "redirect:/viewCart";
	}

	/**
	 * @param productId
	 * @param model
	 * @return
	 */
	@GetMapping("/addToCart/{productId}")
	public String addProductToCart(@PathVariable Long productId, ModelMap model) {
		cartService.addProductToCart(productId);
		return "redirect:/viewProduct";
	}

}
