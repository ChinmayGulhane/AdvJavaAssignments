package com.demo.service;

import java.util.List;
import java.util.Scanner;
import com.demo.beans.Person;
import com.demo.dao.PersonDao;
import com.demo.dao.PersonDaoImpl;

public class PersonServiceImpl implements PersonService {
	private PersonDao pdao;
	
	public PersonServiceImpl() {
		pdao = new PersonDaoImpl();
	}

	@Override
	public void addPerson() {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter Username");
		String uname=sc.nextLine();
		System.out.println("Enter Password");
		String password=sc.nextLine();
		System.out.println("Enter Email");
		String email=sc.nextLine();
		System.out.println("Enter id");
		int id = sc.nextInt();
		Person p = new Person(uname,password,email,id);
		pdao.save(p);
	}

	@Override
	public void delById(int id) {
		pdao.deleteId(id);
	}

	@Override
	public void update(int pid) {
		pdao.modifyById(pid);
	}

	@Override
	public List<Person> display() {
		return pdao.displayAll();
	}

	@Override
	public void closeMyconnection() {
		// TODO Auto-generated method stub
		pdao.closeConnection();
	}

	@Override
	public List<Person> displaySorted() {
		// TODO Auto-generated method stub
		return pdao.findSorted();
	}

	@Override
	public Person getById(int id) {
		// TODO Auto-generated method stub
		return pdao.findById(id);
	}
	
	
	

}
