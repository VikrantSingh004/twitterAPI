package com.nomad.controllers;

import java.util.ArrayList;

import javax.xml.ws.RequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nomad.mdoel.User;
import com.nomad.mdoel.htmlWritter;
import com.nomad.service.UserInfoService;

@RestController
public class userInfoController {
	@Autowired
	UserInfoService userInfoService;
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public boolean addUser(@RequestBody User user) {
		userInfoService.addUser(user);
		return true;
	}
	@RequestMapping(value="/getUser/{uid}/",method=RequestMethod.GET)
	public User getUser(@PathVariable String uid) {
		//String uid="3";
		System.out.println("uid for getUser in controller : "+uid);
		int z =Integer.parseInt(uid);
		return userInfoService.getUser(z);
	}
	@RequestMapping(value="/getMutualFollowers",method=RequestMethod.GET)  // twitter api fn
	public String getMutualFollowers(String body) {
		if(body==null) {body="";}
		return htmlWritter.StringInHtml(body, "parsing twitter api", "Mutual followers");
	}
	@RequestMapping(value="/getAllUser",method=RequestMethod.GET)
	public String getAllUser() {
		System.out.println("?????   inside controller getAllUser");
		String a="";
		int u=0;
		while(u++<6) {
		
		User userObj = userInfoService.getUser(u); 
		if(userObj==null) {continue;}
		a+="\n      user no "+u;
		a+=userObj.toString()+"<>";  //sepearator in htmlWritter
		}System.out.println("?????   returning controller getAllUser");
		return htmlWritter.StringInHtml(a,"All User details","/getAllUser");
	}
	
	@RequestMapping(value="/addFriend/{uid1}/{uid2}",method=RequestMethod.GET)
	public boolean addFriends(@PathVariable String uid1,@PathVariable String uid2) {
		userInfoService.addFriend(uid1,uid2);
		return true;
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String Welcome(String uid) {
		String resp = "Server Startrd!!!";
		resp+="\n    APIs supported are:";
		resp+="\n     1.\t /getAllUser";
		resp+="\n     2.\t /getUser/{uid}";
		resp+="\n     3.\t /addUser";
		resp+="\n     3.\t /addFriends";
		return resp;
	}
	
	//http://localhost:8080/getMutualUser?user1=1&user2=0
	@RequestMapping(value="/getMutualUser",method=RequestMethod.GET)
	public String getFollowers(@RequestParam(value="user1")String u1,@RequestParam (value="user2")String u2) {
		// by pass
				twitterController obj =new twitterController();
				String ans = obj.findMutual(u1,u2);
				System.out.println("ans   "+ans);
		return ans;		
//		int user1=Integer.valueOf(u1);
//		int user2=Integer.valueOf(u2);
//		User user= userInfoService.getUser(user1);
//		User userMutual;
//		System.out.println(user1+"///// "+user2);
//		
//		
//		
//		//
//		if(user2==0) {return user.getFriends();}
//		else {userMutual= userInfoService.getUser(user2);};
//		return mutual(user,userMutual);
	}
	public static ArrayList<String> mutual(User u1,User u2){
		ArrayList res = new ArrayList<String>();
		for(String i:u1.getFriends()) {
			if(u2.getFriends().contains(i)){
				res.add(i);
			}}
		
		return res;
	}
	
}
