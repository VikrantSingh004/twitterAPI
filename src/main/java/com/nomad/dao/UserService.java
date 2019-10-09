package com.nomad.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;
import com.nomad.mdoel.User;


@Repository
public class UserService implements UserDao{
	
	private static Map<Integer,User> DB= new HashMap<Integer,User>();
	
	@Override
	public boolean addUser(int id, User user) {
		System.out.println("?????   inside UserService addUser");
		try {
		DB.put(id,user);}catch(Exception e) { e.printStackTrace();return false;}
		return true;
	}


	@Override
	public User getUser(int id) {
		System.out.println("?????   inside UserService getUser");
		if (DB.containsKey(id))
		return DB.get(id);
		else return null;//new User();
	}
	public void getKeys(){
		Set<Integer> keyset = DB.keySet();
		for(int i : keyset) {
			System.out.println(i+" ");
		}
	}

}
