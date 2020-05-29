/**
 * 
 */
package com.mindtree.app.service;

import java.util.List;

import com.mindtree.app.model.Cart;
import com.mindtree.app.model.Product;

/**
 * @author M1016253
 *
 */

public interface CartService {

	/**
	 * @param productId
	 */
	public void removeProductFromCart(long productId);

	/**
	 * @param productId
	 */
	public void addProductToCart(Long productId);

	public List<Product> viewProductFromCart(Integer cartId);

	/**
	 * @return
	 */
	public List<Cart> viewProductFromCart();

	/**
	 * @param productId
	 * @param quantity
	 */
	public void updateProductInCart(Long productId, int quantity);

}
