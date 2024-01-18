package com.demo.service;

import java.util.List;

import com.demo.beans.Person;

public interface PersonService {

	void addPerson();

	void delById(int id);

	void update(int pid);

	List<Person> display();

	void closeMyconnection();

	List<Person> displaySorted();

	Person getById(int id);

}
