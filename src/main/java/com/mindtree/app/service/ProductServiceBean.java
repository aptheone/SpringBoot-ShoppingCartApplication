/**
 * 
 */
package com.mindtree.app.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.app.exceptions.ResourseNotFoundException;
import com.mindtree.app.model.Apparal;
import com.mindtree.app.model.Book;
import com.mindtree.app.model.Product;
import com.mindtree.app.repository.ProductRepository;

/**
 * @author M1016253
 *
 */
@Service
@Transactional
public class ProductServiceBean implements ProductService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public List<Book> getAllBooks() {
		return productRepository.findAllBooks();
	}

	@Override
	public List<Apparal> getAllApparals() {
		return productRepository.findAllApparals();
	}

	@Override
	public Product searchProductById(Long productId) {
		Optional<Product> product = productRepository.findById(productId);
		if (product.isPresent()) {
			logger.info("Products are :{}" + product);
			return product.get();
		} else {
			throw new ResourseNotFoundException("The product is not found !");
		}
	}

	@Override
	public List<Product> searchProduct(String item) {

		if (item.matches("[0-9]+") && item.length() > 0) {
			logger.info("Search for item :{}" + item);
			return productRepository.productSearch(Long.valueOf(Integer.parseInt(item)), item);
		}
	;
		return productRepository.productSearch(0L, "%" + item + "%");
	}

}
