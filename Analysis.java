package tweetAnalysis;

import java.io.IOException;

public class Analysis {
	
	public static void main(String[] args) throws IOException{
		GetTweets.tweetToString("realDonaldTrump");
		Graph.graph(Graph.read("tweets.txt"));
	}
}
