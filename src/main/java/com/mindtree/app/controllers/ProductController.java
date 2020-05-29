/**
 * 
 */
package com.mindtree.app.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mindtree.app.model.Apparal;
import com.mindtree.app.model.Book;
import com.mindtree.app.model.Product;
import com.mindtree.app.service.ProductService;

/**
 * @author M1016253
 *
 */
@Controller
public class ProductController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductService productService;

	@Value("${spring.application.name}")
	String appName;

	/**
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String homePage(ModelMap model) {
		model.put("appName", appName);
		return "home";
	}

	/**
	 * @param model
	 * @return
	 */
	@GetMapping("/error")
	public String errorPage(ModelMap model) {
		model.put("errMsg", "Application is not responsing due to internal error.");
		return "home";
	}

	/**
	 * @param model
	 * @return
	 */
	@GetMapping("/viewProduct")
	public String viewProductPage(ModelMap model) {
		List<Product> products = productService.getAllProducts();
		model.put("products", products);
		logger.info("Products are :{}" + products);
		return "product";
	}

	/**
	 * @param model
	 * @return
	 */
	@GetMapping("/viewBooks")
	public String viewBooksPage(ModelMap model) {
		List<Book> books = productService.getAllBooks();
		model.put("books", books);
		logger.info("Books are :{}" + books);
		return "view_books";
	}

	/**
	 * @param model
	 * @return
	 */
	@GetMapping("/viewApparals")
	public String viewApparalPage(ModelMap model) {
		List<Apparal> apparals = productService.getAllApparals();
		model.put("apparals", apparals);
		logger.info("Apparals are :{}" + apparals);
		return "view_apparals";
	}

	/**
	 * @param productId
	 * @return
	 */
	@GetMapping(value = "/products/{productId}")
	public Product searchProductById(@PathVariable Long productId) {
		logger.info("Cart is updated for item :{}" + productId);
		return productService.searchProductById(productId);
	}

	/**
	 * @param model
	 * @param items
	 * @return
	 */
	@PostMapping(value = "/search")
	public String searchByCategory(ModelMap model, @PathVariable String items) {
		List<Product> products = productService.searchProduct(items);
		logger.info("Search for item:{}" + items);

		if (products.size() == 0) {
			logger.info("No items found for search :{}" + items);
			model.put("items", true);
		}
		model.put("products", products);
		return "product";
	}

}
