package com.nomad.dao;

import com.nomad.mdoel.User;

public interface UserDao {
	
	boolean addUser(int id, User user);
	User getUser(int id);
	
	default boolean addUser(User user) {
		try {
			addUser(user.setNewId(),user);
		}catch(Exception e){System.out.println("can not add user on this id!!!");e.printStackTrace();return false;}
		return true;
	};
}
