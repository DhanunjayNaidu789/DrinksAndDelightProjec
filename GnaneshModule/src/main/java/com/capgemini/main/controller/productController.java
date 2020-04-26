package com.capgemini.main.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.capgemini.main.entites.OrderDetails;
import com.capgemini.main.entites.RawSpecs;
import com.capgemini.main.exception.InvalidProductException;
import com.capgemini.main.service.ProductServiceInterface;

@RestController
@RequestMapping("/api/v1")
public class productController {
	
	
	@Autowired
	ProductServiceInterface serviceObj;

	
	
	@PostMapping("/placeorder")
	public ResponseEntity<String> addProductOrderEntity(@Valid @RequestBody OrderDetails productEntity)
	{
		serviceObj.orderProduct(productEntity);
		return new ResponseEntity<String>("productorderentity Added",HttpStatus.OK);
	}
	
	@DeleteMapping("/cancelOrder/{id}") 
	public ResponseEntity<String> deleteOrder(@PathVariable String id)
	{
		String result=null;
		Boolean status = serviceObj.cancelProduct(id);
		if(status== true)
			 result = "Order deleted Successfully";
		else
			result = "Unsuccessfull";
		return new ResponseEntity<String>("OrderDeleted", HttpStatus.OK);
	}
	
	@GetMapping("/getProductbyId/{id}")
	public ResponseEntity<OrderDetails> getProductbyId(@PathVariable String id) 
	{
		OrderDetails list = serviceObj.findOrderById(id);
		return new ResponseEntity<OrderDetails>(list,HttpStatus.OK);
	}
	
	@GetMapping("/getProductSpecs/{id}")
	public ResponseEntity<RawSpecs> getProductSpecs(@PathVariable String id)  throws InvalidProductException
	{
	
		RawSpecs list = serviceObj.getProductSpecs(id);
		if(list==null)
			throw new InvalidProductException(id + " " + " Id is not Valid");
		return new ResponseEntity<RawSpecs>(list,HttpStatus.OK);
		}
	
	@GetMapping("/getAllProductSpecs")
    public ResponseEntity<List<RawSpecs>> getProductList() {
			List<RawSpecs> list = serviceObj.retrieve();
			return new ResponseEntity<List<RawSpecs>>(list,HttpStatus.OK);
	}
	@GetMapping("/getAllOrders")
    public ResponseEntity<List<OrderDetails>> getProductOrderList() {
			List<OrderDetails> list = serviceObj.retrieveOrderList();
			return new ResponseEntity<List<OrderDetails>>(list,HttpStatus.OK);
	}
	
	
}
