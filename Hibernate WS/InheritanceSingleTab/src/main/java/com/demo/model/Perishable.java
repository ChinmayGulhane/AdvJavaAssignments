package com.demo.model;

import java.util.Date;

public class Perishable extends Product{
	
	private Date expdt;

	public Perishable() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Perishable(int id, String name, int qty, double price,Date expdt) {
		super(id, name, qty, price);
		this.expdt = expdt;
	}
	
	public Date getExpdt() {
		return expdt;
	}


	public void setExpdt(Date expdt) {
		this.expdt = expdt;
	}


	@Override
	public String toString() {
		return "Perishable [expdt=" + expdt + "]";
	}

	
	
	
	
	

}
