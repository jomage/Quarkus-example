package fr.iocean.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents a product that a client can buy.
 * @author jordi
 *
 */
@Entity
public class Product {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="productSeq")
	private Long id;
	private String name;
	private Double unitPrice;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

}
