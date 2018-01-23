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

import java.io.*;
import java.util.*;
import twitter4j.*;
import twitter4j.conf.*;
//import a.*;
public class GetTweets {
	public static void tweetToString(String user) throws IOException{
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setOAuthConsumerKey("UrpEUlYGr9U51gh0yJHncow1m");
		cb.setOAuthConsumerSecret("h3SHtLHPEfKAOxsJe8BIyXWQji4FvIAGFU9HYfxezGtcLAjvLb");
		cb.setOAuthAccessToken("2453584556-riqTZCwIpFa0Hf1mA3bNNYcFqmG7Bv3Co1zebLJ");
		cb.setOAuthAccessTokenSecret("BUmz9RAMfVFHb5jSAhGX18R1DfO4ogIq6YR2zPtvNnNBi");

		File newFile = new File("tweets.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter("tweets.txt"));
		
		Twitter twitter = new TwitterFactory(cb.build()).getInstance();

		int pageno = 1;
		List statuses = new ArrayList();
		int size;
		while (true) {

		try {
			size = statuses.size(); 
			Paging page = new Paging(pageno++, 100);
			statuses.addAll(twitter.getUserTimeline(user, page));
			if (statuses.size() > 50)
				break;
		      }
			catch(TwitterException e) {

				e.printStackTrace();
			}
		}
		size = statuses.size();
		    
		String fullStr;
		String str;
		int link;
		int retweet;
		int colon;
		for(int i = 0; i < size; i++){
			fullStr = statuses.get(i).toString();
			List<String> items = Arrays.asList(fullStr.split("\\s*,\\s*"));
			str = items.get(2);
			
			if(str.substring(0,5).equals("text="))
				str = str.substring(6);
			
			link = str.indexOf("https");
			
			if(link != -1){
				str = str.substring(0,link);
			}
			
			retweet = str.indexOf("RT @");
			colon = str.indexOf(":");
			if(retweet != -1 && colon != -1){
				str = str.substring(colon+1);
			}
			
			writer.write(str);
		}
		writer.close();
	}
	
	public static void main(String[] args) throws IOException{
		tweetToString("realDonaldTrump");
	}	
}
