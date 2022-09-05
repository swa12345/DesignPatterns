package com.citiustech.service;

import java.time.LocalDate;
import java.util.List;

import com.citiustech.exception.ItemAlreadyExistException;
import com.citiustech.exception.ItemNotFoundException;
import com.citiustech.model.Product;

public interface InventoryService {

	public void addProduct(Product p) throws ItemAlreadyExistException;
	public LocalDate calculateExpiryDate(int productId) throws ItemNotFoundException;
	public LocalDate calculateExpiryDate(Product productId) throws ItemNotFoundException;
	public void removeExpiredItems() throws ItemNotFoundException;
	public List<Product> sortItemsInDesc() throws ItemNotFoundException;
	public void calculateDiscount() throws ItemNotFoundException;
	Product getProduct(int productId) throws ItemNotFoundException;
	
}
