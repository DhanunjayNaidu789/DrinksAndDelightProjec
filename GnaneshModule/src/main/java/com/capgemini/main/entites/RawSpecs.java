package com.capgemini.main.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@DynamicInsert
@DynamicUpdate	
@Table(name = "Raw_Specs")
public class RawSpecs {

		@Id
		String rmsId;
		String name;
		double pricePerUnit;
		String description;
		
	
		public  RawSpecs() {
			
		}
		
		
		
		public RawSpecs(String rmsId,String name, double pricePerUnit, String description) {
			super();
			this.rmsId = rmsId;
			this.name = name;
			this.pricePerUnit = pricePerUnit;
			this.description = description;
		}
		
		
		
		public String getRmsId() {
			return rmsId;
		}



		public void setRmsId(String rmsId) {
			this.rmsId = rmsId;
		}



		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getPricePerUnit() {
			return pricePerUnit;
		}
		public void setPricePerUnit(double pricePerUnit) {
			this.pricePerUnit = pricePerUnit;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		
		
		
		
		
		
	}
