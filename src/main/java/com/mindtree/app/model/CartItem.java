/**
 * 
 */
package com.mindtree.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * @author M1016253
 *
 */

@Entity
public class CartItem implements Serializable {

	private static final long serialVersionUID = -7781593135796601352L;

	
	@EmbeddedId
    private CartItemPK pk;
	
	public CartItem() {
	}

	public CartItem(Cart cart, Product product, Double cartPrice, Integer quantity) {
		this.pk = new CartItemPK();
		pk.setCart(cart);
		pk.setProduct(product);
		this.cartPrice = cartPrice;
		this.quantity = quantity;
	}

	@Column(nullable = false, unique = false)
	private Double cartPrice;
	
	
	@Column(nullable = false, unique = false)
	private Integer quantity;
	

    @Transient
    public Product getProduct() {
        return this.pk.getProduct();
    }
 
    @Transient
    public Double getTotalPrice() {
        return getProduct().getPrice() * getQuantity();
    }

	/**
	 * @return the pk
	 */
	public CartItemPK getPk() {
		return pk;
	}

	/**
	 * @param pk the pk to set
	 */
	public void setPk(CartItemPK pk) {
		this.pk = pk;
	}

	/**
	 * @return the price
	 */
	public Double getCartPrice() {
		return cartPrice;
	}

	/**
	 * @param price the price to set
	 */
	public void setCartPrice(Double cartPrice) {
		this.cartPrice = cartPrice;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		CartItem other = (CartItem) obj;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}

	
	
}
