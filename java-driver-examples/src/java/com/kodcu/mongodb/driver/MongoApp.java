package com.kodcu.mongodb.driver;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

/**
 * Created by Hakan on 4/29/2015.
 */
public class MongoApp {

    public static void main(String[] args) {
        final MongoClient client = new MongoClient(new MongoClientURI("mongodb://localhost"));
        final MongoDatabase twitter = client.getDatabase("twitter");

        final TweetDAO tweet = new TweetDAOImp(twitter);

        System.out.println("/** Count Tweets By User Name **/");
        System.out.println(tweet.countTweetsBy("kodcu.com"));

        System.out.println("/** Count Tweets By User Id **/");
        System.out.println(tweet.findTweetBy("553bbecae8f1e57878b72a1e"));

        System.out.println("/** Count Tweets By Verified Users **/");
        System.out.println(tweet.countTweetsByVerifiedUsers());

        String lang = "tr";
        System.out.format("/** Count Tweets Written in %s **/\n", lang);
        System.out.println(tweet.countTweetsWrittenIn(lang));

        String[] langs = {"tr","en"};
        System.out.format("/** Count Tweets Written in [%s and %s] **/\n", langs);
        System.out.println(tweet.countTweetsWrittenIn(langs));

        System.out.println("/** Count Unique Twitter Users **/");
        System.out.println(tweet.countTwitterUsers());

        int followers = 1_000_000;
        System.out.format("/** Count Users By Followers >= %d **/\n", followers);
        System.out.println(tweet.countUsersByFollowersGreaterThan(followers));

        System.out.format("/** Find Users By Followers >= %d **/\n", followers);
        List<Document> tweets = tweet.findUsersByFollowersGreaterThan(followers);
        tweets.forEach(System.out::println);

        System.out.println("/** Index Details of the Tweets Collection **/");
        tweet.getCollectionIndexDetails();

        String search = "maç";
        System.out.format("/** Count Tweets By Searching %s **/\n",search);
        System.out.println(tweet.countTweetsByTextSearch(search));

        int number = 330;
        System.out.format("/** Count Tweets By Favorites >= %d users **/\n", number);
        System.out.println(tweet.countTweetsByFavoritesGreaterThan(number));

        System.out.format("/** Count Tweets By Retweets >= %d users **/\n", number);
        System.out.println(tweet.countTweetsByRetweetsGreaterThan(number));

        String hashtag = "MongoDB";
        System.out.format("/** Count Tweets including the '%s' hashtag **/\n",hashtag);
        System.out.println(tweet.countTweetsIncluding(hashtag));

        System.out.println("/** Print the collection name **/");
        System.out.println(tweet.getCollectionName());

        client.close();
    }

}