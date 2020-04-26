package com.capgemini.main.dao;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.main.entites.StockDetails;



@Transactional
@Repository
public class ProductDaoImplementation implements ProductDaoInterface{

	@PersistenceContext
	EntityManager entityManager;
	
	
	
	
	

	
	@Override
	public StockDetails getProductSpecs(String stockId) {
		return entityManager.find(StockDetails.class,stockId);
	}

	
	
	@Override
	public List<StockDetails> reterive() {
		String Qstr=" from StockDetails";
		TypedQuery<StockDetails> query=entityManager.createQuery(Qstr,StockDetails.class);
		System.out.println("dao impl");
		return query.getResultList();
		}



	@Override
	public StockDetails updateProduct(String stockId, StockDetails details) {
	
	StockDetails details1=entityManager.find(StockDetails.class, stockId);
//		if(details!=null) {
//			if(entityManager.find(StockDetails.class, stockId) != null)
//
//
//
////			
	if(stockId==details1.getStockId()) {
			details1.setManufactureDate(details.getManufactureDate());
			System.out.println(details.getManufactureDate());
			details1.setExpiryDate(details.getExpiryDate());
	}
////			
//			
//		}
//	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
//	LocalDate man=LocalDate.parse(manufactureDate, formatter);
//			details1.setManufactureDate(man);
//			System.out.println(details.getManufactureDate());
//			LocalDate exp=LocalDate.parse(expiryDate, formatter);
//			details1.setExpiryDate(exp);
		return details1;
		
	}



	

}
