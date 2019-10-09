package com.nomad.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.social.connect.Connection;
import org.springframework.social.oauth1.OAuthToken;
import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nomad.mdoel.htmlWritter;

import ch.qos.logback.core.net.SyslogOutputStream;
import twitter4j.TwitterFactory;

@RestController
@RequestMapping(twitterController.twitter_base_api)
public class twitterController {
//	static String consumerKey="suSm5kdQUYIsqZbWgV15u7MtI";
//	static String consumerSecret="B6CBxKZzw8Sps6dv6F0wGG9oGg3iuKDxR0Ek0xrdtrrrLzMcGk";
//	static String Token="500743328-Lqozsaxt09fI2ZsGGM8jKrG84yKmXtBOwAWGaKiR";
//	static String TokenKey="6qQ8iRk1LHK7JHcZJY35qci5DL29vD0xvoCCeFUGbmeqg";
	
	static String consumerKey="fzeh5mJpwNhMkGzKdoza9mZ9N";
	static String consumerSecret="w63flWIDr0gMY4ZFb4ifnsAECM7ZnmlYM2warGSCUz8lwDxdiZ";
	static String Token="500743328-zG9rqLycx6dOoqSV7oqnhzTqGKtQGJGJ8t64USZR";
	static String TokenKey="NnscLRzVqoPjAOFOwih6DsDbn1akc9gJZONtbd552zfgb";	

	public static final String twitter_base_api="/twitter/followers";
	
	OAuthToken accessToken= new OAuthToken(Token,TokenKey); 
	TwitterConnectionFactory fac = new TwitterConnectionFactory(consumerKey, consumerSecret);
	Connection<Twitter> conTwitter = fac.createConnection(accessToken);
	Twitter twitter = conTwitter.getApi();
	
	//http://localhost:8080/findMutual?user1=vikrant654&user2=ratnaishu07
	//@RequestMapping(value="/findMutual",method=RequestMethod.GET)	
	public String findMutual(
			@RequestParam(value="user1")String uid1,@RequestParam (value="user2")String uid2) {
		//@PathVariable String uid1,@PathVariable String uid2) {
		System.out.println("----------------common followers for "+uid1+" "+uid2);
		List<String> list1 = getProfiles(twitter,uid1);
		List<String> list2 = getProfiles(twitter,uid2);
		list1.retainAll(list2);
		String ans = list1.stream().reduce(" ", (x,y)->x+" "+y);
		System.out.println(ans);
		return htmlWritter.StringInHtml(list1.toString(),"All User details","/getAllUser");
		//return list1;
	}
	@RequestMapping(value="search/{hashtag}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Tweet> getTweets(@PathVariable final String hashtag){
		return twitter.searchOperations().search(hashtag,20).getTweets() ;
	}
	@RequestMapping(value="{userID}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<String> getFollowers(@PathVariable final String userID){
		//CursoredList<Long> followers=twitter.friendOperations().getFollowerIds(userID);
		//System.out.println(userID +"-- total followers for this user :" + followers.size());
		return getProfiles(twitter,userID);
		

		
//		ArrayList<String> nameList=new ArrayList<String>();
//		for(Long follower : followers) {
//			try {
//			String screenName =twitter.userOperations().getUserProfile(follower).getScreenName();
//			System.out.print(screenName+", ");
//			nameList.add(screenName);
//			}catch (Exception e) {System.out.println("session time out !!! + \n updated followers list Size: "+ nameList.size());
//				e.printStackTrace();;
//				break;}
//		}//return followers;//twitter.friendOperations().getFollowerIds(userID);
//		return nameList;
		}
	private List<String> getProfiles(Twitter twitter,String userID) {
		CursoredList<TwitterProfile> followersName=twitter.friendOperations().getFollowersInCursor(userID,-1);
		List<String> ans = new ArrayList<String>();
		int count =0;
		while (!followersName.isEmpty() && count<1) {
			System.out.println(count++);
			followersName.stream().forEach(x->ans.add(x.getScreenName()));
			Long cursor=followersName.getNextCursor();
			followersName=twitter.friendOperations().getFollowersInCursor(userID,cursor);
		}
		System.out.println("ans :: "+ans);
		System.out.println("size of nameList: "+ ans.size());
		return ans;
	}
		
}
