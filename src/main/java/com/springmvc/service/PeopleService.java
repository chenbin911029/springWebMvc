package com.springmvc.service;

import com.springmvc.pojo.People;

import java.util.List;


public interface PeopleService {

	People findById(long id);

	People findByName(String name);
	
	void saveUser(People user);
	
	void updateUser(People user);
	
	void deleteUserById(long id);

	List<People> findAllUsers();
	
	void deleteAllUsers();
	
	public boolean isUserExist(People user);
	
}
