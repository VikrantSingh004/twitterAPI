package com.nomad.mdoel;

import java.util.ArrayList;
import java.util.Random;

import com.jayway.jsonpath.spi.json.GsonJsonProvider;

import net.minidev.json.JSONObject;

public class User {
	

	private int id;
	private String name;
	private transient ArrayList<String> friends=new ArrayList<String>();
	
	public User(int id, String name, ArrayList<String> friends) {
		this.id = id;
		this.name = name;
		this.friends = friends;
	}
	public User() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int setNewId() {
		if (this.id == 0) return 0;
		return this.id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getFriends() {
		return friends;
	}
	public void setFriends(ArrayList<String> friends) {
		this.friends = friends;
	} 
	public void addFriend(String friendID) {
		if(this.friends.contains(friendID)) {return;};
		System.out.println(friendID +" friendID adding friends to user "+this.name);
		this.friends.add(friendID);
	}
	@Override
	public String toString() {
		try {
		return responder.objToJson(this);}
		catch(Exception e){
		return "{ Name :"+name+" id :" +id+" }";}
	}
	
	
}
