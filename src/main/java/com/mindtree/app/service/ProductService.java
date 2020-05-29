/**
 * 
 */
package com.mindtree.app.service;

import java.util.List;

import com.mindtree.app.model.Apparal;
import com.mindtree.app.model.Book;
import com.mindtree.app.model.Product;

/**
 * @author M1016253
 *
 */

public interface ProductService {

	/**
	 * @return
	 */
	public List<Product> getAllProducts();

	/**
	 * @return
	 */
	public List<Book> getAllBooks();

	/**
	 * @return
	 */
	public List<Apparal> getAllApparals();

	/**
	 * @param productId
	 * @return
	 */
	public Product searchProductById(Long productId);

	/**
	 * @param items
	 * @return
	 */
	public List<Product> searchProduct(String items);

}
