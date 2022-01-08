package com.RestWeb.DaoServices;

import java.util.*;

import org.springframework.stereotype.Component;

import com.RestWeb.Entity.User;

@Component
public class UserDaoServices {
	
	private static List<User> users = new ArrayList<User>();
	static {
		
		users.add(new User(8,"Radha", new Date()));
		users.add(new User(9,"Seeta", new Date()));
		users.add(new User(10,"Reeta", new Date()));
	}
	public List<User> getAllUsers(){
		return users;
	}
	public User  getUser(Integer id){
		int length = users.size();
		for(int i = 0 ;i< length;i++) {
			if(users.get(i).getId()== id) {
				return users.get(i);
			}
		}
		return null;
		
	}
	public User deleteUser(Integer id) {
		for(User u: users) {
			if(u.getId()== id) {
				users.remove(u); 
				return u;
			}
		}
		return null;
	}
	/*public void updateUser(Integer id) {
		for(User u: users) {
			if(u.getId()== id) {
				u.setId(id);
				u.setName("hh");
				u.setBirthDate(new Date());
				users.add(u);
			}
			
		}
		
	}*/
	public void updateUser(User u) {
		for(User user: users) {
			if(user.getId()== u.getId()) {
				user.setName(u.getName());
				user.setBirthDate(u.getBirthDate());
			}
		}
	}
	public User createUser(User u) {
		users.add(u);
		return u;
	}

}
