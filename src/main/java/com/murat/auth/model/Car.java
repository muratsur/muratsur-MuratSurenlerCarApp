package com.murat.auth.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Car {

	@Id	
	private String vin;
	private String make;
	private String model;
	private String color;
	private int year;
	
	@ManyToOne
	private SalesRep salesRep;
	
	
	
	public Car(String vin, String make, String model, String color, int year, SalesRep salesRep) {
		super();
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.salesRep = salesRep;
	}

	public Car() {
		super();
		
	}

	public SalesRep getSalesRep() {
		return salesRep;
	}

	public void setSalesRep(SalesRep salesRep) {
		this.salesRep = salesRep;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, make, model, salesRep, vin, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(color, other.color) && Objects.equals(make, other.make)
				&& Objects.equals(model, other.model) && Objects.equals(salesRep, other.salesRep)
				&& Objects.equals(vin, other.vin) && year == other.year;
	}

	@Override
	public String toString() {
		return "Car [vin=" + vin + ", make=" + make + ", model=" + model + ", color=" + color + ", year=" + year
				+ ", salesRep=" + salesRep + "]";
	}

	
	
}
