package com.nomad.twitApi;
import twitter4j.api.FriendsFollowersResources;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

import org.apache.commons.logging.Log;

import twitter4j.*;
public class parseApi {
	public static List<User> getFriends() {
		List<User> friendList = null;

try {
	ConfigurationBuilder confbuilder = new ConfigurationBuilder();
    confbuilder.setOAuthAccessToken(AccessToken)
            .setOAuthAccessTokenSecret(secretToken)
            .setOAuthConsumerKey(TwitterOAuthActivity.CONSUMER_KEY)
            .setOAuthConsumerSecret(TwitterOAuthActivity.CONSUMER_SECRET);
    Twitter mtwitter = new TwitterFactory(confbuilder.build()).getInstance();
	
    IDs ids = mTwitter.getFriendsIDs(-1);// ids
    // for (long id : ids.getIDs()) {
    do {
        for (long id : ids.getIDs()) {               


            String ID = "followers ID #" + id;
            String[] firstname = ID.split("#");
            String first_Name = firstname[0];
            String Id = firstname[1];

            System.out.println("split..........."+ first_Name + Id);

            String Name = mTwitter.showUser(id).getName();
            String screenname = mTwitter.showUser(id).getScreenName();


//            Log.i("id.......", "followers ID #" + id);
//          Log.i("Name..", mTwitter.mTwitter.showUser(id).getName());
//          Log.i("Screen_Name...", mTwitter.mTwitter.showUser(id).getScreenName());
//          Log.i("image...", mTwitter.mTwitter.showUser(id).getProfileImageURL());


        }
    } while (ids.hasNext());

} catch (Exception e) {
    e.printStackTrace();
}
	    return friendList;
	}
}
