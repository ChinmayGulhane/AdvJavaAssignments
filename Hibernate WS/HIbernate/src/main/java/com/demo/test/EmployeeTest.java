package com.demo.test;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.demo.model.Employee;


public class EmployeeTest{
	public static void main(String args[]) {
		Employee e1=new Employee(1,"Tom",25000);
		Employee e2=new Employee(2,"Jerry",24000);

		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session sess= sf.openSession();
		Transaction tr=sess.beginTransaction();
//		sess.save(e1);
//		sess.save(e2);
		tr.commit();
		sess.close();
		
		e2.setName("Oggy");
		Session sess1= sf.openSession();
		Employee e3=new Employee(3,"Jerry",290);
		Transaction tr1=sess1.beginTransaction();
		//sess1.update(e2);
		sess1.merge(e2);

		//sess1.save(e3);
		tr1.commit();
		sess1.close();
		

		         
		
		
	}
}