package com.citiustech.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.exception.ItemAlreadyExistException;
import com.citiustech.exception.ItemNotFoundException;
import com.citiustech.model.Product;
import com.citiustech.repository.ProductRepository;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	public ProductRepository productRepository;

	@Override
	public void addProduct(Product p) throws ItemAlreadyExistException {
		if (p == null)
			return;
		Product newProduct = new Product(p.getId(), p.getDescription(), p.getWeight(), p.getPrice(),
				p.getManufacturingDate(), p.getUseBeforeDate());
		System.out.println(newProduct);
		try {
			productRepository.save(newProduct);
		} catch (IllegalArgumentException e) {
			throw new ItemAlreadyExistException("Item already exists or passing some illegal arguments");
		}

	}

	@Override
	public LocalDate calculateExpiryDate(int productId) throws ItemNotFoundException {
		Optional<Product> product = productRepository.findById(productId);
		Product p = product.orElseThrow(() -> new ItemNotFoundException("Item not found"));
		return calculateExpiryDate(p);

	}

	@Override
	public LocalDate calculateExpiryDate(Product product) throws ItemNotFoundException {
		LocalDate expiryDate = (product.getManufacturingDate()).plusMonths(product.getUseBeforeDate());
		System.out.println(expiryDate);
		return expiryDate;

	}

	@Override
	public void removeExpiredItems() throws ItemNotFoundException {
		List<Product> p = (List<Product>) productRepository.findAll();
		LocalDate currentDate = LocalDate.now();
		System.out.println("current date " + currentDate);
		List<Product> expiredProducts = p.stream().filter(i -> {
			try {
				return currentDate.isAfter(calculateExpiryDate(i));
			} catch (ItemNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				return false;
			}
		}).collect(Collectors.toList());
		productRepository.deleteAll(expiredProducts);
//		for(Product p1 : p) {		
//		System.out.println(expiryDate);
//		 String date2 = expiryDate.format(dtf);
//		if(date1.compareTo(date2) > 0) {
//			productRepository.delete(p1);
//			System.out.println(p1);
//		}

//		 if (currentDate.isAfter(expiryDate)) {
//			 System.out.println(p1);
//			 
//			 productRepository.delete(p1);
//		 }

	}

	@Override
	public List<Product> sortItemsInDesc() throws ItemNotFoundException {
		return productRepository.getSortedProducts();

	}

	@Override
	public void calculateDiscount() throws ItemNotFoundException {
		List<Product> p = (List<Product>) productRepository.findAll();

		for (Product p1 : p) {
			LocalDate expiryDate = calculateExpiryDate(p1.getId());
			LocalDate plusSixMonths = expiryDate.plusMonths(6);
			System.out.println("Months " + plusSixMonths);
			if (expiryDate.isBefore(plusSixMonths)) {
				p1.setPrice(p1.getPrice() - (p1.getPrice() * 20 / 100));
				System.out.println("Price " + p1.getPrice());
			}
		}

	}

	@Override
	public Product getProduct(int productId) throws ItemNotFoundException {
		Optional<Product> product = productRepository.findById(productId);
		Product p = product.orElseThrow(() -> new ItemNotFoundException("Item Not Found"));
		System.out.println(p);
		return p;

	}

}
