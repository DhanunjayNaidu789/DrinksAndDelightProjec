package com.capgemini.main.dao;

import java.util.List;

import com.capgemini.main.entites.OrderDetails;
import com.capgemini.main.entites.RawSpecs;

public interface ProductDaoInterface {
	public boolean placeOrder(OrderDetails productEntity);
	public boolean cancelOrder(String orderId);
	public RawSpecs getProductSpecs(String rmsId);
	public OrderDetails findOrderById(String id);
	public List<RawSpecs> reterive();
	public List<OrderDetails> reteriveOrderList();
	}
