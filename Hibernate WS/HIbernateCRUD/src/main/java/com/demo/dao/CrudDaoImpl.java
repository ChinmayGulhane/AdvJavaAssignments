package com.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.demo.model.MyUser;

public class CrudDaoImpl implements CrudDao{

	static SessionFactory sf;
	
	static {
		sf = HibernateUtil.getSF();
	}
	
	public void save(MyUser u) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		sess.save(u);
		tr.commit();
		sess.close();
	}

	public List<MyUser> findAll() {
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		Query q = sess.createQuery("from MyUser");
		List<MyUser> ulist = q.list();
		tr.commit();
		sess.close();
		return ulist;
	}

	public MyUser findById(int uid) {
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		MyUser u = sess.get(MyUser.class,uid);
		tr.commit();
		sess.close();
		return u;
	}

	public boolean delById(int uid) {
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		MyUser u =sess.get(MyUser.class,uid);
		if(u!=null) {
			sess.delete(u);
			tr.commit();
			sess.close();
			return true;
			}
		sess.close();
		return false;
	}

	@Override
	public boolean editById(int uid, String unm, String street) {
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		MyUser u = sess.get(MyUser.class,uid);
		if(u!=null) {
			u.setUname(unm);
			u.getAddr().setStreet(street);
			
		sess.merge(u);
		tr.commit();
		sess.close();
		return true;
		}
		sess.close();
		return false;
	}

	@Override
	public List<MyUser> sortById() {
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		Query q=sess.createQuery("from MyUser u order by u.uid desc");
		List<MyUser> ulist = q.list();
		tr.commit();
		sess.close();
		return ulist;
	}
	
	public void closeSessFac() {
		HibernateUtil.closeSF();
	}
	

}
