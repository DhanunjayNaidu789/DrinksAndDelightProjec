package com.capgemini.main.dao;

import java.time.LocalDate;
import java.util.List;


import com.capgemini.main.entites.StockDetails;

public interface ProductDaoInterface {
	
	public StockDetails getProductSpecs(String stockId);
	
	public List<StockDetails> reterive();

	

	public StockDetails updateProduct(String stockId, StockDetails details);

	

	

}
