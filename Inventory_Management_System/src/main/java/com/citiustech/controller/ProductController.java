package com.citiustech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.exception.ItemAlreadyExistException;
import com.citiustech.exception.ItemNotFoundException;
import com.citiustech.model.Product;
import com.citiustech.service.InventoryService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	public InventoryService inventoryService;
	
	@PostMapping("/addProducts")
	public ResponseEntity<String> addNewProduct(@RequestBody Product product){
		System.out.println("first value");
		try {
			inventoryService.addProduct(product);
			return new ResponseEntity<String>("ProductAddedSuccessfully",HttpStatus.OK);
		}catch(ItemAlreadyExistException e) {
			return new ResponseEntity<String>("Item Already Exist",HttpStatus.BAD_REQUEST);
		}
	
		
	}
	
	@GetMapping("/calculateExpiryDate/{productId}")
	public ResponseEntity<String> calculateExpiryDate(@PathVariable Integer productId) {
		try {
			inventoryService.calculateExpiryDate(productId);
			return new ResponseEntity<String>("Expiry Calculated",HttpStatus.OK);
		} catch (ItemNotFoundException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<String>("Not able to calculate expiry date",HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("/removeExpiredItems")
	public ResponseEntity<String> removeExpiredItems() throws ItemNotFoundException {
			inventoryService.removeExpiredItems();
			return new ResponseEntity<String>("Expired Items Removed",HttpStatus.OK);
		
	}
	
	@GetMapping("/sortItemsInDesc")
	public ResponseEntity<?> sortItemsInDesc() throws ItemNotFoundException {
		return ResponseEntity.ok(inventoryService.sortItemsInDesc());
	}
	
	@GetMapping("/calculateDiscount")
	public ResponseEntity<String> calculateDiscount() throws ItemNotFoundException {
		inventoryService.calculateDiscount();
		return new ResponseEntity<String>("Discount Calculated",HttpStatus.OK);
	}
	
	@GetMapping("/getProduct/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable int productId) throws ItemNotFoundException {
		Product product = inventoryService.getProduct(productId);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	
	
}
