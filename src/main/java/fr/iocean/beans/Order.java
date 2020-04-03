package fr.iocean.beans;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Represent an order that a client purchased in an online store.
 * @author jordi
 *
 */
@Entity
@Table(name = "order_")
public class Order {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="orderSeq")
	private Long id;
	private String shippingAddress;
	private Date dateOrdered;
	/**
	 * List of products ordered.
	 */
	@ManyToMany
	private List<Product> productsOrdered;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Date getDateOrdered() {
		return dateOrdered;
	}
	public void setDateOrdered(Date dateOrdered) {
		this.dateOrdered = dateOrdered;
	}
	public List<Product> getProductsOrdered() {
		return productsOrdered;
	}
	public void setProductsOrdered(ArrayList<Product> productsOrdered) {
		this.productsOrdered = productsOrdered;
	}

}
