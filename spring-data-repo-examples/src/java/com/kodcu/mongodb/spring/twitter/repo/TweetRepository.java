package com.kodcu.mongodb.spring.twitter.repo;

import com.kodcu.mongodb.spring.twitter.db.Tweet;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Collection;
import java.util.stream.Stream;

/**
 * Created by Hakan on 5/23/2015.
 */
public interface TweetRepository extends MongoRepository<Tweet, String>, TweetDAO {

    @Query(value = "{'user.id_str': ?0}", count = true)
    Long countTweets(String userId);

    @Query(value = "{'user.name': ?0}", count = true)
    Long countTweetsByUserName(String userName);

    Long countTweetsByFavorited(boolean b);
    Long countTweetsByFavoritedIsFalse();
    Long countByFavoritedIsTrue();

    Stream<Tweet> findTweetsByFavorited(boolean b);
    Stream<Tweet> findByFavorited(boolean b);
    Stream<Tweet> getTweetsByFavorited(boolean b);
    Stream<Tweet> readTweetsByFavorited(boolean b);
    Stream<Tweet> streamTweetsByFavorited(boolean b);

    // text search support
    @Query(value = "{$text: {$search: ?0}}", count = true)
    Long countByTextSearch(String text);
    Long countAllBy(TextCriteria criteria);

    @Query(value = "{favorite_count : {$gte : ?0}}", count = true)
    Long countByFavoritesGreaterThanEqual(int favoriteCount);

    @Query(value = "{retweet_count : {$gte : ?0}}", count = true)
    Long countTweetsByRetweetsGreaterThanEqual(int favoriteCount);

    @Query(value = "{'user.verified': true}", count = true)
    Long countTweetsByVerifiedUsers();

    Long countByLangIn(Collection lang);
    Long countTweetsByLangIn(Collection lang);
    // regex
    Long countByLangRegex(String lang);

    @Query(value = "{'entities.hashtags.text':?0}", count = true)
    Long countTweetsIncluding(String hashtag);

}
