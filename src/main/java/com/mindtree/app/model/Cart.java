/**
 * 
 */
package com.mindtree.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 * @author M1016253
 *
 */
@Entity
@NamedQueries(value = {
		@NamedQuery(name = "Cart.findProductByCartId", query = "select c from Cart c where c.cartId=?1"),
		@NamedQuery(name = "Cart.deleteProductFromCartById", query = "delete from Cart c where c.cartId=?1"),
		@NamedQuery(name = "Cart.updateProductInCart", query = "update CartItem ci set ci.quantity=:quantity where ci.pk.product.productId=:productId"),
		@NamedQuery(name = "Cart.deleteProductFromCart", query = "delete from Cart c"),
		@NamedQuery(name = "Cart.viewProductFromCart", query = "select c from Cart c")
		})
public class Cart implements Serializable {

	public Cart() {

	}

	private static final long serialVersionUID = -6413466667070047771L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartId;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pk.product")
	private List<CartItem> cartItems = new ArrayList<>();

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
   @Transient
    public Double getTotalCartPrice() {
	   Double sum = 0D;
        List<CartItem> cartItems = getCartItems();
        for (CartItem op : cartItems) {
            sum += op.getTotalPrice();
        }
        return sum;
    }
 
    @Transient
    public int getNumberOfItems() {
        return this.cartItems.size();
    }

	/**
	 * @return the cartId
	 */
	public Integer getCartId() {
		return cartId;
	}

	/**
	 * @param cartId the cartId to set
	 */
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	/**
	 * @return the cartItems
	 */
	public List<CartItem> getCartItems() {
		return cartItems;
	}

	/**
	 * @param cartItems the cartItems to set
	 */
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Cart other = (Cart) obj;
		if (cartId == null) {
			if (other.cartId != null)
				return false;
		} else if (!cartId.equals(other.cartId))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

    
    
}
