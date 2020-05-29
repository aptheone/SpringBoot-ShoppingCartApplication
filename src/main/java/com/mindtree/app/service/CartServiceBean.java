/**
 * 
 */
package com.mindtree.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.app.exceptions.ResourseNotFoundException;
import com.mindtree.app.model.Cart;
import com.mindtree.app.model.CartItem;
import com.mindtree.app.model.Product;
import com.mindtree.app.repository.CartRepository;
import com.mindtree.app.repository.ProductRepository;

/**
 * @author M1016253
 *
 */
@Service
@Transactional
public class CartServiceBean implements CartService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void removeProductFromCart(long productId) {
		logger.info("productId is removed from card :{}" + productId);
		cartRepository.deleteById(productId);
	}

	@Override
	public List<Product> viewProductFromCart(Integer cartId) {
		return cartRepository.findProductByCartId(cartId);
	}

	@Override
	public void addProductToCart(Long productId) {
		
		Optional<Product> product = productRepository.findById(productId);
		if (product.isPresent()) {
			logger.info("Products are :{}" + product);
		} else {
			throw new ResourseNotFoundException("The product is not found !");
		}
		long cartCount = cartRepository.count();
		Cart cart = cartRepository.findById((long) 1).orElse(null);
		if (cartCount == 0) {
			cart = new Cart();
			cart.setCartId(1);
			cartRepository.save(cart);

		}
		
		List<CartItem> cartItems= new ArrayList<>();
		CartItem cartItem= new CartItem();
		cart.setCartItems(cartItems);
		cartRepository.save(cart);

	}

	@Override
	public List<Cart> viewProductFromCart() {
		return cartRepository.findAll();
	}

	@Override
	public void updateProductInCart(Long productId, int quantity) {

		if (quantity == 0) {
			logger.info("productId is removed from card :{}" + productId);
			removeProductFromCart(productId);
		} else {
			logger.info("product quantity is updated :{}" + quantity);
			cartRepository.updateProductInCart(productId, quantity);
		}

	}
}
