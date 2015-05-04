package com.kodcu.mongodb.spring;

import com.kodcu.mongodb.spring.twitter.db.Tweet;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

/**
 * Created by Hakan on 4/27/2015.
 */
interface TweetDAO {

    /**
     * find a tweet written by the given user_id
     *
     * @param id user id
     * @return a {@link Tweet} object
     */
    Tweet findTweetBy(String id);

    /**
     * count the number of tweets tweeted by the verified users
     *
     * @return the expected count
     */
    long countTweetsByVerifiedUsers();

    /**
     * count the number of tweets written in the given language
     *
     * @param language for example: type tr or en
     * @return the expected count
     */
    long countTweetsWrittenIn(String language);

    /**
     * count the number of tweets written in the given languages
     *
     * @param languages for example: type tr and en
     * @return the expected count
     */
    long countTweetsWrittenIn(String... languages);

    /**
     * count tweets written by the given user name
     *
     * @param twitterUser a twitter user_name
     * @return the expected tweets' number
     */
    long countTweetsBy(String twitterUser);

    /**
     * count the number of unique twitter users
     *
     * @return the expected count
     */
    int countTwitterUsers();

    /**
     * count the number of users whose followers are >= the given number
     *
     * @param followersCount for example: type 100000 which points the number of followers for the lower bound
     * @return the number of users with the specified criteria
     */
    long countUsersByFollowersGreaterThan(int followersCount);

    /**
     * find users whose followers are >= the given number of followers
     *
     * @param followersCount for example: type 100000 which points the number of followers for the lower bound
     * @return AggregationResults which contains the list of {@link com.kodcu.mongodb.spring.TweetDAOImp.TwitterStats}
     */
    AggregationResults<TweetDAOImp.TwitterStats> findUsersByFollowersGreaterThan(int followersCount);

    String getCollectionName();

    void getCollectionIndexDetails();

    /**
     * count the number of tweets containing the given text using full text search. Please note that, in order to get results
     * you need to create a text index based on the text field along with its default_language that must be turkish | tr which
     * we automatically generate a text index using a spring annotation.
     *
     * @param text that you want to search
     * @return the expected number of tweets
     */
    long countTweetsByTextSearch(String text);

    /**
     * count the number of tweets favorited by >= the given number of users
     *
     * @param nOfUsers 10000
     * @return the expected number of tweets
     */
    long countTweetsByFavoritesGreaterThan(int nOfUsers);

    /**
     * count the number of tweets retweeted by >= the given number of users
     *
     * @param nOfUsers 10000
     * @return the expected number of tweets
     */
    long countTweetsByRetweetsGreaterThan(int nOfUsers);

    /**
     * count the number of tweets that contains the given hashtag in their tweet description
     *
     * @param hashtag for example: type mongodb or java
     * @return the expected number of tweets
     */
    long countTweetsIncluding(String hashtag);
}
