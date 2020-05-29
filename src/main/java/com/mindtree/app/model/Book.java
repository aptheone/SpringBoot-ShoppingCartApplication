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
import javax.persistence.Table;

/**
 * @author M1016253
 *
 */
@Entity
@Table(name = "Books")
@NamedQueries(value = {
		@NamedQuery(name = "Book.findBooks", query = "select p from Product p where p.productCategory=?1"),
		@NamedQuery(name = "Book.findAllBooks", query = "select b from Book b") })
@Inheritance(strategy = InheritanceType.JOINED)
public class Book extends Product implements Serializable {

	public Book() {
	}

	private static final long serialVersionUID = -7410331791819108061L;

	@Column(nullable = false, unique = false)
	private String genre;

	@Column(nullable = false, unique = false)
	private String authour;

	@Column(nullable = false, unique = false)
	private String publications;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the authour
	 */
	public String getAuthour() {
		return authour;
	}

	/**
	 * @param authour the authour to set
	 */
	public void setAuthour(String authour) {
		this.authour = authour;
	}

	/**
	 * @return the publications
	 */
	public String getPublications() {
		return publications;
	}

	/**
	 * @param publications the publications to set
	 */
	public void setPublications(String publications) {
		this.publications = publications;
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
		result = prime * result + ((authour == null) ? 0 : authour.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((publications == null) ? 0 : publications.hashCode());
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
		Book other = (Book) obj;
		if (authour == null) {
			if (other.authour != null)
				return false;
		} else if (!authour.equals(other.authour))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (publications == null) {
			if (other.publications != null)
				return false;
		} else if (!publications.equals(other.publications))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [genre=" + genre + ", authour=" + authour + ", publications=" + publications + "]";
	}

}
