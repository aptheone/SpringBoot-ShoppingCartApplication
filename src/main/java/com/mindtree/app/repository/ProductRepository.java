/**
 * 
 */
package com.mindtree.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindtree.app.model.Apparal;
import com.mindtree.app.model.Book;
import com.mindtree.app.model.Product;

/**
 * @author M1016253
 *
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Book> findBooks(@Param("category") String category);

	List<Book> findAllBooks();

	List<Apparal> findApparals(@Param("category") String category);

	List<Apparal> findAllApparals();

	List<Product> productSearch(@Param("productId") Long productId, @Param("productName") String productName);

}
