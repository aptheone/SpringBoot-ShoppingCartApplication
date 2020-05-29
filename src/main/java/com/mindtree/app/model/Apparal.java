/**
 * 
 */
package com.mindtree.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * @author M1016253
 *
 */

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "Apparal.findApparals", query = "select p from Product p where p.productCategory=?1"),
		@NamedQuery(name = "Apparal.findAllApparals", query = "select a from Apparal a")		
})
@Inheritance(strategy = InheritanceType.JOINED)
public class Apparal extends Product implements Serializable {

	public Apparal() {
	}

	private static final long serialVersionUID = 4786040531338549445L;

	@Column(nullable = false, unique = false)
	private String type;

	@Column(nullable = false, unique = false)
	private String brand;

	@Column(nullable = false, unique = false)
	private String design;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the design
	 */
	public String getDesign() {
		return design;
	}

	/**
	 * @param design the design to set
	 */
	public void setDesign(String design) {
		this.design = design;
	}
	
	

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((design == null) ? 0 : design.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apparal other = (Apparal) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (design == null) {
			if (other.design != null)
				return false;
		} else if (!design.equals(other.design))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Apparal [type=" + type + ", brand=" + brand + ", design=" + design + "]";
	}

	
}
