package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Address;
import com.demo.model.MyUser;

public class UserTest {

	public static void main(String[] args) {
		Address addr1 = new Address(1,"Nashik","MH");
		Address addr2 = new Address(2,"Yavatmal","MH");
		MyUser u1 = new MyUser(10,"Priyanka",addr1);
		MyUser u2 = new MyUser(12,"Chinmay",addr2);
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tr =sess.beginTransaction();
		sess.save(addr1);
		sess.save(addr2);
		sess.save(u1);
		sess.save(u2);
		
		tr.commit();
		
	}
}