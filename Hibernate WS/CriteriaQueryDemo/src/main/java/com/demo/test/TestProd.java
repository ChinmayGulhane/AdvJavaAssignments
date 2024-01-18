package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Product;

public class TestProd {

	public static void main(String[] args) {
		 SessionFactory sf = new Configuration().configure().buildSessionFactory();
		 Session sess = sf.openSession();
		 Transaction tr = sess.beginTransaction();
		 Product p1 = new Product(1,"Tom",5,85);
		 Product p2 = new Product(2,"Jerry",6,856);
		 Product p3 = new Product(3,"Caterpillar",1,500);
		 sess.save(p1);
		 sess.save(p2);
		 sess.save(p3);
		 tr.commit();
		 sess.close();
		 
	}

}
