package com.nomad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nomad.dao.UserDao;
import com.nomad.dao.UserService;
import com.nomad.mdoel.User;
import com.nomad.dao.UserDao;

@Service
public class UserInfoService {
	@Autowired
	private final UserService UserService;
	
	@Autowired
	public UserInfoService( UserService userDao) {
		System.out.println("?????   inside UserInfoService constructor");
		this.UserService = userDao;
		defaultUser();
	}
	public boolean addUser(User user) {
		this.UserService.addUser(user);
		return true;
	}
	public User getUser(int parseInt) {
		System.out.println("?????   inside UserInfoService getUser");
		return this.UserService.getUser(parseInt);
	}
	public void defaultUser() {
		System.out.println("?????? filling default data");
		User user1 = new User();
		user1.setId(3);
		user1.setName("vo");
		Boolean addvalue= this.UserService.addUser(user1);
		if(addvalue==true) {System.out.println(" ????  user added succesfully");}
		else {System.out.println("failed to add  user");}
	}
	public boolean addFriend(String uid1, String uid2) {
		System.out.println("keys:::::::::;");
		this.UserService.getKeys();
		User u1 = this.UserService.getUser(Integer.parseInt(uid1));
		System.out.println(">>>>>>>>> "+u1.getName());
		u1.addFriend(uid2);
		try {
		this.UserService.getUser(Integer.parseInt(uid2)).addFriend(uid1);
		}catch(Exception e) {System.out.println("user 2 not found");}
		return true;
	}
	
	
}
