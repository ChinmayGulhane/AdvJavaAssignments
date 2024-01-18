package com.demo.dao;

import java.util.List;

import com.demo.beans.Person;

public interface PersonDao {

	void save(Person p);

	void deleteId(int id);

	void modifyById(int pid);

	List<Person> displayAll();

	void closeConnection();

	List<Person> findSorted();

	Person findById(int id);

}
