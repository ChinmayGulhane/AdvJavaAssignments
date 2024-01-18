package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.dao.CrudDao;
import com.demo.dao.CrudDaoImpl;
import com.demo.model.Address;
import com.demo.model.MyUser;

public class CrudServiceImpl implements CrudService{
	private CrudDao udao;

	public CrudServiceImpl() {
		udao=new CrudDaoImpl();
	}

	public void addnewUser() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enetr user id");
		int uid=sc.nextInt();
		System.out.println("enetr user name");
		String uname=sc.next();
		System.out.println("enetr address id");
		int aid=sc.nextInt();
		System.out.println("enetr street");
		String street=sc.next();
		System.out.println("enetr city");
		String city=sc.next();
		MyUser u=new MyUser(uid,uname,new Address(aid,street,city));
		udao.save(u);
			
	}

	public List<MyUser> getAllUsers() {
		return udao.findAll();
	}

	public MyUser getById(int uid) {
		return udao.findById(uid);
	}

	public boolean removeById(int uid) {
		return udao.delById(uid);
	}

	public boolean modifyById(int uid, String unm, String street) {
		return udao.editById(uid, unm, street);
	}

	public List<MyUser> sortById() {
		// TODO Auto-generated method stub
		return udao.sortById();
	}

	public void closeMySessionFactory() {
		udao.closeSessFac();
		
	}


}