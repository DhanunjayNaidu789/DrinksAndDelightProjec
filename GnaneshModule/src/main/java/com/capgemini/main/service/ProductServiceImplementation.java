package com.capgemini.main.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.main.dao.ProductDaoInterface;
import com.capgemini.main.entites.OrderDetails;
import com.capgemini.main.entites.RawSpecs;


@Service
@Transactional
public class ProductServiceImplementation implements ProductServiceInterface{

	@Autowired
	ProductDaoInterface daoObj;
	
	List<String> rmsList = new ArrayList<String>();
	
	
	
	
	@Override
	public void orderProduct(OrderDetails productEntity) {
		boolean check = daoObj.placeOrder(productEntity);
		if(check==true)
		{
			System.out.println("Order placed");
		}
		else
		{
			System.out.println("Order is not placed");
		}
		
	}

	@Override
	public boolean cancelProduct(String orderId) {
		return daoObj.cancelOrder(orderId);
		
	}

	@Override
	public RawSpecs getProductSpecs(String rmsId) {
			return daoObj.getProductSpecs(rmsId);
	}

	@Override
	public OrderDetails findOrderById(String id) {
		return daoObj.findOrderById(id);
	}

	@Override
	public List<RawSpecs> retrieve() {
		return daoObj.reterive();
	}

	@Override
	public List<OrderDetails> retrieveOrderList() {
		return daoObj.reteriveOrderList();
	}




	
	
	

}
