package com.capgemini.drinksanddelight.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.drinksanddelight.entities.Distributordetails;
import com.capgemini.drinksanddelight.entities.ProductorderDetails;


@Transactional
@Repository
public class ProjectDaoImpl implements ProjectDao{
	
	
	
	@PersistenceContext
	EntityManager entityManager;
	

	@Override
	public List<Distributordetails> reterive() {
		// TODO Auto-generated method stub
		String Qstr="SELECT distributordetails from Distributordetails distributordetails";
		TypedQuery<Distributordetails> query=entityManager.createQuery(Qstr,Distributordetails.class);
		System.out.println("dao impl");
		return query.getResultList();
	}

	@Override
	public boolean updateTrackOrder(String orderId, String Location, LocalDate date) {
		
		String stql="UPDATE ProductorderDetails p SET p.location=:ploc,p.expectedDeliveryDate=:pdate where p.orderId=:pid";
		
		 Query query = entityManager.createQuery(stql);
		 query.setParameter("pid", orderId);
		 query.setParameter("ploc", Location);
		 query.setParameter("pdate", date);
		 int rows=query.executeUpdate();
		 
		// TODO Auto-generated method stub
		 if(rows==1)
		 {
			 return true;
		 }
		 else
		 {
		return false;
		 }
	}

	@Override
	public ProductorderDetails trackOrder(String id) {
		// TODO Auto-generated method stub
		ProductorderDetails object=entityManager.find( ProductorderDetails.class,id);
		
		if(object==null)
		{
			return null;
		}
		else
		{
		String jpql="select productdetails from ProductorderDetails productdetails where orderId=:oid";
		TypedQuery< ProductorderDetails> query =  entityManager.createQuery(jpql,  ProductorderDetails.class);
		query.setParameter("oid", id);
		return query.getSingleResult();
		}
	}

}
