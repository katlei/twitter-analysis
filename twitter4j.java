package tweetAnalysis;

import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.conf.*;

import java.util.*;
import twitter4j.*;
import twitter4j.conf.*;
//import a.*;
public class Analyze {
	public static void main(String[] args){

		    ConfigurationBuilder cb = new ConfigurationBuilder();
		    cb.setOAuthConsumerKey("YOUR KEYS HERE");
		    cb.setOAuthConsumerSecret("YOUR KEYS HERE");
		    cb.setOAuthAccessToken("YOUR KEYS HERE");
		    cb.setOAuthAccessTokenSecret("YOUR KEYS HERE");

		    Twitter twitter = new TwitterFactory(cb.build()).getInstance();

		    int pageno = 1;
		    String user = "cnn";
		    List statuses = new ArrayList();

		    while (true) {

		      try {

		        int size = statuses.size(); 
		        Paging page = new Paging(pageno++, 100);
		        statuses.addAll(twitter.getUserTimeline(user, page));
		        if (statuses.size() == size)
		          break;
		      }
		      catch(TwitterException e) {

		        e.printStackTrace();
		      }
		    }

		    System.out.println("Total: "+statuses.size());
		}
		
		/**
	    Twitter twitter = new TwitterFactory().getInstance();
        try {
            List<twitter4j.Status> statuses;
            String user;
            if (args.length == 1) {
                user = args[0];
                statuses = twitter.getUserTimeline(user);
            } else {
                user = twitter.verifyCredentials().getScreenName();
                statuses = twitter.getUserTimeline();
            }
            System.out.println("Showing @" + user + "'s user timeline.");
            for (twitter4j.Status status : statuses) {
                System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
            }
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        }
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("*********************")
		  .setOAuthConsumerSecret("******************************************")
		  .setOAuthAccessToken("**************************************************")
		  .setOAuthAccessTokenSecret("******************************************");
	
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		**/
	
}




