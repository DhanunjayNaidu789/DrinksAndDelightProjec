package com.capgemini.main.entites;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Value;

@Entity
@DynamicInsert
@DynamicUpdate
public class OrderDetails {
	@Id
	@Size(min=2,max=10,message="orderId should be atleast 2 digits")
	private String orderId;
	private String name;
	@Size(min=2,max=10,message="orderId should be atleast 2 digits")
	private String SupplierId;
	private double quantityValue;
	private double quantityUnit;
	private double pricePerUnit;
	private double totalPrice;
	private String location;
	
	public OrderDetails()
	{
		
	}
	
	public OrderDetails( String orderId,String name, String supplierId, double quantityValue, double quantityUnit,
			double pricePerUnit,  double totalPrice, String location) {
		super();
		this.orderId = orderId;
		this.name = name;
		SupplierId = supplierId;
		this.quantityValue = quantityValue;
		this.quantityUnit = quantityUnit;
		this.pricePerUnit = pricePerUnit;
		this.totalPrice = totalPrice;
		this.location = location;
	}

		public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSupplierId() {
		return SupplierId;
	}

	public void setSupplierId(String supplierId) {
		SupplierId = supplierId;
	}

	public double getQuantityValue() {
		return quantityValue;
	}

	public void setQuantityValue(double quantityValue) {
		this.quantityValue = quantityValue;
	}

	public double getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(double quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	
	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
