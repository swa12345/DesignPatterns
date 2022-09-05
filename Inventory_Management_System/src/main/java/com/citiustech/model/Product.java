package com.citiustech.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ProductDetails")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
	private int weight;
	private double price;
	private LocalDate manufacturingDate;
	private int useBeforeDate;
	
	public Product() {
		super();
	}
	
	public Product(int id, String description, int weight, double price, LocalDate manufacturingDate,int useBeforeDate) {
		super();
		this.id = id;
		this.description = description;
		this.weight = weight;
		this.price = price;
		this.manufacturingDate = manufacturingDate;
		this.useBeforeDate = useBeforeDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getManufacturingDate() {
		return manufacturingDate;
	}
	public void setManufacturingDate(LocalDate manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	public int getUseBeforeDate() {
		return useBeforeDate;
	}
	public void setUseBeforeDate(int useBeforeDate) {
		this.useBeforeDate = useBeforeDate;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", weight=" + weight + ", price=" + price
				+ ", manufacturingDate=" + manufacturingDate + ", useBeforeDate=" + useBeforeDate + "]";
	}
	
}
