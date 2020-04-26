package com.capgemini.main.service;

import java.util.List;

import com.capgemini.main.entites.OrderDetails;
import com.capgemini.main.entites.RawSpecs;

public interface ProductServiceInterface {
	
	public void orderProduct(OrderDetails productEntity);
	public boolean cancelProduct(String orderId);
	public RawSpecs getProductSpecs(String rmsId);
	public OrderDetails findOrderById(String id);
	public List<RawSpecs> retrieve();
	public List<OrderDetails> retrieveOrderList();
}
