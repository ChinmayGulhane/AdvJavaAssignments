package com.demo.test;



import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.NonPerishable;
import com.demo.model.Perishable;

public class TestSin{

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Perishable p1=new Perishable(12,"1.0",0,1.0,new Date());
		NonPerishable p2=new NonPerishable(13,"2.0",0,1.0,"xas");
		session.save(p2);
		session.save(p1);
		tr.commit();

	}

}