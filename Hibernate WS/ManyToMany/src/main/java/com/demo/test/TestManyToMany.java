package com.demo.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Project;
import com.demo.model.Employee;

public class TestManyToMany {

	public static void main(String[] args) {
		
		Employee e1=new Employee(1,"aaaa");
		Employee e2=new Employee(2,"bbbb");
		Employee e3=new Employee(3,"xxxx");
		Employee e4=new Employee(4,"ccccc");
		Set<Employee> eset1=new HashSet<Employee>();
		eset1.add(e1);
		eset1.add(e2);
		eset1.add(e3);
		Set<Employee> eset2=new HashSet<Employee>();
		eset2.add(e1);
		eset2.add(e4);
		eset2.add(e3);
		Project p1=new Project(10,"Gaming");
		Project p2=new Project(11,"Rocketry");
		p1.setEset(eset1);
		p2.setEset(eset2);
		Set<Project> pset1=new HashSet<Project>();
		pset1.add(p1);
		pset1.add(p2);
		Set<Project> pset2=new HashSet<Project>();
		pset2.add(p1);
		Set<Project> pset3=new HashSet<Project>();
		pset3.add(p2);
		e1.setPset(pset1);
		e2.setPset(pset2);
		e3.setPset(pset1);
		e4.setPset(pset3);
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.save(p1);
		session.save(p2);
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(e4);
		tr.commit();
	}

}