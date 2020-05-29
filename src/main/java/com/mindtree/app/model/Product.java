/**
 * 
 */
package com.mindtree.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author M1016253
 *
 */
@Entity
@NamedQueries(value = { @NamedQuery(name = "Product.findProductById", query = "FROM Product p WHERE p.productId = ?1"),
		@NamedQuery(name = "Product.findProductByQuantity", query = "select count(*) as count from Product p"),
		@NamedQuery(name = "Product.viewAllProduct", query = "select p from Product p"),
		@NamedQuery(name = "Product.productSearch", query = "select p from Product p where p.productId=:productId or lower(p.productName) like :productName") 
})
@Inheritance(strategy = InheritanceType.JOINED)
public class Product implements Serializable {

	public Product() {
	}
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 8428082636427872003L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;

	@Column(nullable = false, unique = false)
	private String productName;

	@Column(nullable = false, unique = false)
	private Double price;

	@Column(nullable = false, unique = false)
	private String productCategory;

	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the productCategory
	 */
	public String getProductCategory() {
		return productCategory;
	}

	/**
	 * @param productCategory the productCategory to set
	 */
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
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
		Product other = (Product) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", productCategory=" + productCategory + "]";
	}
	
	

	


}
