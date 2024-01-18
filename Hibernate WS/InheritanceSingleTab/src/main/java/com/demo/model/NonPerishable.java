package com.demo.model;

public class NonPerishable extends Product {
	
	private	String category;

	public NonPerishable() {
		super();
		// TODO Auto-generated constructor stub
	}


	public NonPerishable(int id, String name, int qty, double price,String category) {
		super(id, name, qty, price);
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "NonPerishable [category=" + category + "]";
	}
	
	
	
	

}
