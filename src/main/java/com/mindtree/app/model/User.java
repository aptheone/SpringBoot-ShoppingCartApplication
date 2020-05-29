/**
 * 
 */
package com.mindtree.app.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author M1016253
 *
 */

@Entity
@Table(name = "Users")
@NamedQueries(value = { @NamedQuery(name = "User.findUserById", query = "select u from User u where u.userId=?1"),
		@NamedQuery(name = "User.viewAllUsers", query = "select u from User u") })
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -732742513443779395L;

	public User() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@Column(nullable = false, unique = false)
	private String userName;

	@Column(nullable = false, unique = false)
	private String userEmailId;

	@Column(nullable = false, unique = false)
	private Integer userPhoneNo;

	@Column(nullable = false, unique = false)
	private String userAddress;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private Cart cart;

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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

	/**
	 * @return the userEmailId
	 */
	public String getUserEmailId() {
		return userEmailId;
	}

	/**
	 * @param userEmailId the userEmailId to set
	 */
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	/**
	 * @return the userPhoneNo
	 */
	public Integer getUserPhoneNo() {
		return userPhoneNo;
	}

	/**
	 * @param userPhoneNo the userPhoneNo to set
	 */
	public void setUserPhoneNo(Integer userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}

	/**
	 * @return the userAddress
	 */
	public String getUserAddress() {
		return userAddress;
	}

	/**
	 * @param userAddress the userAddress to set
	 */
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		User other = (User) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

}
