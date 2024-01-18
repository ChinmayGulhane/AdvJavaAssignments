package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.demo.model.Product;

public class ProductTest{
	public static void main(String args[]) {
		
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	Session sess=sf.openSession();
	Transaction tr=sess.beginTransaction();
	Product p1=sess.get(Product.class,1);  
	sess.close();
	
	p1.setPname("shelf");
	
	Session sess2=sf.openSession();
	Transaction tr2=sess2.beginTransaction();
	Product p2= sess2.get(Product.class, 1);
	Product p3 =new Product(4,"ex1.0&2.0",1,5);
	sess2.merge(p1);
	sess2.save(p3);
	tr2.commit();
	sess2.close();
	sf.close();
	
	}
}