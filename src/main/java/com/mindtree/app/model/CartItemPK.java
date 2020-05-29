/**
 * 
 */
package com.mindtree.app.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author M1016253
 *
 */
@Embeddable
public class CartItemPK implements Serializable {

	private static final long serialVersionUID = -8470135472702727166L;

	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id")
	private Cart cart;

	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private Product product;

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the cart
	 */
	public Cart getCart() {
		return cart;
	}

	/**
	 * @param cart the cart to set
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItemPK other = (CartItemPK) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

}
