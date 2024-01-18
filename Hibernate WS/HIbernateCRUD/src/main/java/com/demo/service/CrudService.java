package com.demo.service;

import java.util.List;

import com.demo.model.MyUser;

public interface CrudService {

	void addnewUser();

	MyUser getById(int uid);

	boolean removeById(int uid);

	boolean modifyById(int uid, String unm, String street);

	List<MyUser> sortById();

	void closeMySessionFactory();

	List<MyUser> getAllUsers();

}
