package com.demo.test;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.demo.model.Product;

public class TestProduct {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		
		Criteria cr = sess.createCriteria(Product.class);
		List<Product> plist = cr.list();
		plist.forEach(System.out::println);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		//Criterion pricegt = Restrictions.gt("price",300);
		Criterion pricest = Restrictions.lt("price", 800.00);
		Criterion qtygt = Restrictions.gt("qty",4);
		Criteria cr1 = sess.createCriteria(Product.class);
		LogicalExpression e = Restrictions.or(pricest, qtygt);
		cr1.add(e);
		plist = cr1.list();
		plist.forEach(System.out::println);
		
		cr.setFirstResult(0);
		cr.setMaxResults(2);
		plist=cr.list();
		plist.forEach(System.out::println);
		System.out.println("************************************");
		//to find only first 2 records
		cr.setFirstResult(1);
		cr.setMaxResults(2);
		plist=cr.list();
		plist.forEach(System.out::println);
		System.out.println("************************************");
		
		//using JPQL
		System.out.println("using JPQL");
		CriteriaBuilder cb=sess.getCriteriaBuilder();
		CriteriaQuery<Product> cr2=cb.createQuery(Product.class);
		Root<Product> rt=cr2.from(Product.class);
		Query q=sess.createQuery(cr2.select(rt));
		plist=q.getResultList();
		plist.forEach(System.out::println);
		System.out.println("************************************");
				
		
		
		
		
		
		
		
		
		
		tr.commit();
		sess.close();
	
		
		
	}

}
