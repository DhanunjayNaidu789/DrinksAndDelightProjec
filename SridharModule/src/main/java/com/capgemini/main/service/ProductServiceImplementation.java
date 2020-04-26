package com.capgemini.main.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.main.dao.ProductDaoInterface;

import com.capgemini.main.entites.StockDetails;


@Service
@Transactional
public class ProductServiceImplementation implements ProductServiceInterface{

	@Autowired
	ProductDaoInterface daoObj;
	
	


	@Override
	public StockDetails getProductSpecs(String stockId) {
		return daoObj.getProductSpecs(stockId);
	}
	
	

	
	@Override
	public List<StockDetails> retrieve() {
		
		return daoObj.reterive();
	}




	@Override
	public StockDetails updateProduct(String stockId, StockDetails details) {
		
		return daoObj.updateProduct(stockId, details);
	}




	
	
	

}
