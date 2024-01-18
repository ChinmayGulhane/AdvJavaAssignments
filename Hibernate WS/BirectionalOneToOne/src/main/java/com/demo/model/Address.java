package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="useadd")
public class Address {
	@Id
	private int aid;
	private String street;
	private String city;
	@OneToOne(mappedBy="addr")
	private MyUser user;

	public Address() {
		super();
	}
	
	
	
	public Address(int aid, String street, String city) {
		super();
		this.aid = aid;
		this.street = street;
		this.city = city;
	}



	public Address(int aid, String street, String city, MyUser user) {
		super();
		this.aid = aid;
		this.street = street;
		this.city = city;
		this.user = user;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [aid=" + aid + ", street=" + street + ", city=" + city + ", user=" + user + "]";
	}

	
	

}
