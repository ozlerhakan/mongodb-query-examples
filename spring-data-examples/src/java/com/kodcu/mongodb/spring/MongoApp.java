package com.kodcu.mongodb.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

/**
 * Created by Hakan on 4/27/2015.
 */
public class MongoApp {

    private static final Log log = LogFactory.getLog(MongoApp.class);

    public static void main(String[] args) {

        final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfiguration.class);
        final TweetDAO tweet = ctx.getBean(TweetDAOImp.class);

        System.out.println("/** Count Tweets By User Name **/");
        System.out.println(tweet.countTweetsBy("voxxed"));

        System.out.println("/** Count Tweets By User Id **/");
        System.out.println(tweet.findTweetBy("553bbecae8f1e57878b72a1e"));

        System.out.println("/** Count Tweets By Verified Users **/");
        System.out.println(tweet.countTweetsByVerifiedUsers());

        String lang = "tr";
        System.out.format("/** Count Tweets Written in %s **/\n", lang);
        System.out.println(tweet.countTweetsWrittenIn(lang));

        String[] langs = {"tr","en"};
        System.out.format("/** Count Tweets Written in [%s %s] **/\n", langs);
        System.out.println(tweet.countTweetsWrittenIn(langs));

        System.out.println("/** Count Unique Twitter Users **/");
        System.out.println(tweet.countTwitterUsers());

        int followers = 1_000_000;
        System.out.format("/** Count Users By Followers >= %d **/\n", followers);
        System.out.println(tweet.countUsersByFollowersGreaterThan(followers));

        System.out.format("/** Find Users By Followers >= %d **/\n", followers);
        AggregationResults<TweetDAOImp.TwitterStats> tweets = tweet.findUsersByFollowersGreaterThan(followers);
        tweets.forEach(System.out::println);

        System.out.println("/** Index Details of the Tweets Collection **/");
        tweet.getCollectionIndexDetails();

        String search = "maç";
        System.out.format("/** Count Tweets By Searching %s **/\n",search);
        System.out.println(tweet.countTweetsByTextSearch(search));

        int nOfUsers = 330;
        System.out.format("/** Count Tweets By Favorites >= %d users **/\n", nOfUsers);
        System.out.println(tweet.countTweetsByFavoritesGreaterThan(nOfUsers));

        System.out.format("/** Count Tweets By Retweets >= %d users **/\n", nOfUsers);
        System.out.println(tweet.countTweetsByRetweetsGreaterThan(nOfUsers));

        String hashtag = "MongoDB";
        System.out.format("/** Count Tweets including the '%s' hashtag **/\n",hashtag);
        System.out.println(tweet.countTweetsIncluding(hashtag));

        System.out.println("/** Print the collection name **/");
        System.out.println(tweet.getCollectionName());

        ctx.close();
    }
}
