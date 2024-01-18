package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.demo.model.*;



public class BidirectionalOneToOneTest {

	public static void main(String[] args) {
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		
		Address a1= new Address(4,"str1","Pune");
		MyUser u1 = new MyUser(6,"Tom", a1);
		
		sess.save(a1);
		sess.save(u1);
		tr.commit();
		
	}
	
}
