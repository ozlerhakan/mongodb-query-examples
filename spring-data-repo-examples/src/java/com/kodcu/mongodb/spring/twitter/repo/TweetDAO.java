package com.kodcu.mongodb.spring.twitter.repo;

import org.springframework.data.mongodb.core.aggregation.AggregationResults;

/**
 * Created by Hakan on 4/27/2015.
 */
public interface TweetDAO {

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
     * @return AggregationResults which contains the list of {@link TweetRepositoryDAO.TwitterStats}
     */
    AggregationResults<TweetRepositoryDAO.TwitterStats> findUsersByFollowersGreaterThan(int followersCount);

    String getCollectionName();

    void getCollectionIndexDetails();

}
