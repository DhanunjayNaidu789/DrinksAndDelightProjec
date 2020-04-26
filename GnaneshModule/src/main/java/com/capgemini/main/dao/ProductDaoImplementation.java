package com.capgemini.main.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.main.entites.OrderDetails;
import com.capgemini.main.entites.RawSpecs;



@Transactional
@Repository
public class ProductDaoImplementation implements ProductDaoInterface{

	@PersistenceContext
	EntityManager entityManager;
	
	
	
	@Override
	public boolean placeOrder(OrderDetails productEntity) {
		{
		entityManager.persist(productEntity);	
		return true;
		}
	}

	@Override
	public boolean cancelOrder(String orderId) {
		
		{
			entityManager.remove(entityManager.find(OrderDetails.class, orderId));
			return true;
		}
	}

	@Override
	public RawSpecs getProductSpecs(String rmsId) {
		 RawSpecs ref = entityManager.find(RawSpecs.class,rmsId);
		 if(ref!=null)
		 {
			 return ref; 
		 }
		 return null;
		 
	}

	@Override
	public OrderDetails findOrderById(String id) {
		return entityManager.find(OrderDetails.class, id);
	}
	
	
	@Override
	public List<RawSpecs> reterive() {
		String Qstr="SELECT product from RawSpecs product";
		TypedQuery<RawSpecs> query=entityManager.createQuery(Qstr,RawSpecs.class);
		return query.getResultList();
		}

	
	
	
	@Override
	public List<OrderDetails> reteriveOrderList() {
		String Qstr="SELECT order from OrderDetails order";
		TypedQuery<OrderDetails> query=entityManager.createQuery(Qstr,OrderDetails.class);
		return query.getResultList();
	}

	
	
	

}
