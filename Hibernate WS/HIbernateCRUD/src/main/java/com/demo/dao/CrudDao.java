package com.demo.dao;

import java.util.List;

import com.demo.model.MyUser;

public interface CrudDao {

	void save(MyUser u);

	List<MyUser> findAll();

	MyUser findById(int uid);

	boolean delById(int uid);

	void closeSessFac();

	boolean editById(int uid, String unm, String street);

	List<MyUser> sortById();


}
