package com.springmvc.service.impl;

import com.springmvc.pojo.People;
import com.springmvc.service.PeopleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service("peopleService")
@Transactional
public class PeopleServiceImpl implements PeopleService {
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<People> users;
	
	static{
		users= populateDummyUsers();
	}

	public List<People> findAllUsers() {
		return users;
	}
	
	public People findById(long id) {
		for(People user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public People findByName(String name) {
		for(People user : users){
			if(user.getUsername().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	public void saveUser(People user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	public void updateUser(People user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(long id) {
		
		for (Iterator<People> iterator = users.iterator(); iterator.hasNext(); ) {
			People user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isUserExist(People user) {
		return findByName(user.getUsername())!=null;
	}
	
	public void deleteAllUsers(){
		users.clear();
	}

	private static List<People> populateDummyUsers(){
		List<People> users = new ArrayList<People>();
		users.add(new People(counter.incrementAndGet(),"陈彬", "NY", "sam@abc.com"));
		users.add(new People(counter.incrementAndGet(),"托尼", "ALBAMA", "tomy@abc.com"));
		users.add(new People(counter.incrementAndGet(),"凯莉", "NEBRASKA", "kelly@abc.com"));
		return users;
	}

}
