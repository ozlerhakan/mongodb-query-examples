package com.kodcu.mongodb.spring;

import com.kodcu.mongodb.spring.twitter.db.Tweet;
import com.kodcu.mongodb.spring.twitter.repo.TweetRepository;
import com.kodcu.mongodb.spring.twitter.repo.TweetRepositoryDAO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.TextCriteria;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Hakan on 4/27/2015.
 */
public class MongoApp {

    private static final Log log = LogFactory.getLog(MongoApp.class);

    public static void main(String[] args) {

        final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfiguration.class);
        final TweetRepository tweet = ctx.getBean(TweetRepository.class);

        System.out.println("------------------------------------");
        System.out.println("------- From MongoRepository -------");

        System.out.println("Count the number of tweets");
        long count = tweet.count();
        System.out.println(count);

        System.out.println("/** Find tweet by given 2 tweet ids **/");
        Iterable<String> ids = Arrays.asList("553bbecae8f1e57878b72a1e", "553bbecae8f1e57878b72a25");
        Iterable<Tweet> iterableTweets = tweet.findAll(ids);
        Collections.singleton(iterableTweets).forEach(System.out::println);

        System.out.println("/** Check whether 553bbecae8f1e57878b72a1a is exist or not **/");
        boolean exists = tweet.exists("553bbecae8f1e57878b72a1a");
        System.out.println(exists);

        System.out.println("/** Find One By Tweet ID **/");
        System.out.println(tweet.findOne("553bbecae8f1e57878b72a1c"));

        System.out.println("/** Count tweet by given user id **/");
        System.out.println(tweet.countTweets("96951800"));

        System.out.println("/** Count Tweets By User Name **/");
        System.out.println(tweet.countTweetsByUserName("voxxed"));

        System.out.println("/** Count Tweets By Favorites **/");
        System.out.println(tweet.countTweetsByFavorited(false));

        System.out.println("/** Count the number of favorited tweets that are false**/");
        System.out.println(tweet.countTweetsByFavoritedIsFalse());

        System.out.println("/** Count the number of favorited tweets that are true**/");
        System.out.println(tweet.countByFavoritedIsTrue());

        String search = "maç";
        System.out.format("/** Count Tweets By Searching %s **/\n", search);
        System.out.println(tweet.countByTextSearch(search));
        System.out.println(tweet.countAllBy(TextCriteria.forDefaultLanguage().matching(search)));

        System.out.println("/** Get all tweets favorited by me**/");
        tweet.streamTweetsByFavorited(true).forEach(System.out::println);

        int nOfUsers = 330;
        System.out.format("/** Count Tweets By Favorites >= %d users **/\n", nOfUsers);
        System.out.println(tweet.countByFavoritesGreaterThanEqual(nOfUsers));

        System.out.format("/** Count Tweets By Retweets >= %d users **/\n", nOfUsers);
        System.out.println(tweet.countTweetsByRetweetsGreaterThanEqual(nOfUsers));

        System.out.println("/** Count Tweets By Verified Users **/");
        System.out.println(tweet.countTweetsByVerifiedUsers());

        String[] lang = {"tr"};
        System.out.format("/** Count Tweets Written in %s **/\n", lang);
        System.out.println(tweet.countByLangIn(Arrays.asList(lang)));

        String[] langs = {"tr", "en"};
        System.out.format("/** Count Tweets Written in [%s %s] **/\n", langs);
        System.out.println(tweet.countTweetsByLangIn(Arrays.asList(langs)));

        String hashtag = "MongoDB";
        System.out.format("/** Count Tweets including the '%s' hashtag **/\n", hashtag);
        System.out.println(tweet.countTweetsIncluding(hashtag));

        System.out.println("/** Count Tweets By Lang tr using Regex **/");
        System.out.println(tweet.countByLangRegex("tr"));

        System.out.println("------------------------------------");
        System.out.println("------------------------------------");
        System.out.println("----------- From TweetDAO ----------");

        System.out.println("/** Count Unique Twitter Users **/");
        System.out.println(tweet.countTwitterUsers());

        int followers = 1_000_000;
        System.out.format("/** Count Users By Followers >= %d **/\n", followers);
        System.out.println(tweet.countUsersByFollowersGreaterThan(followers));

        System.out.format("/** Find Users By Followers >= %d **/\n", followers);
        AggregationResults<TweetRepositoryDAO.TwitterStats> tweets = tweet.findUsersByFollowersGreaterThan(followers);
        tweets.forEach(System.out::println);

        System.out.println("/** Index Details of the Tweets Collection **/");
        tweet.getCollectionIndexDetails();

        System.out.println("/** Print the collection name **/");
        System.out.println(tweet.getCollectionName());

        System.out.println("------------------------------------");

        ctx.close();
    }
}
