/**
 * 
 */
package com.mindtree.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindtree.app.model.Cart;
import com.mindtree.app.model.Product;

/**
 * @author M1016253
 *
 */
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	@Modifying
	void deleteProductFromCartById(@Param("productId") int productId);

	@Modifying
	void deleteProductFromCart();

	List<Product> findProductByCartId(Integer cartId);

	@Modifying
	void updateProductInCart(@Param("productId") Long productId, @Param("quantity") int quantity);

}
