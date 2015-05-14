package com.kodcu.mongodb.spring;

import com.kodcu.mongodb.spring.twitter.db.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.IndexOperations;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.index.IndexInfo;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

/**
 * Created by Hakan on 4/27/2015.
 */
@Component
class TweetDAOImp implements TweetDAO {

    private final MongoOperations mongos;

    @Autowired
    public TweetDAOImp(final MongoOperations mongos) {
        this.mongos = mongos;
    }

    public Tweet findTweetBy(String id) {
        return mongos.findOne(Query.query(Criteria.where("_id").is(id)), Tweet.class);
    }

    private long countTweets(Criteria criteria) {
        Query query = Query.query(criteria);
        return mongos.count(query, Tweet.class);
    }

    public long countTweetsByVerifiedUsers() {
        Criteria criteria = Criteria.where("user.verified").is(true);
        return countTweets(criteria);
    }

    public long countTweetsWrittenIn(String language) {
        Criteria criteria = Criteria.where("lang").is(language);
        return countTweets(criteria);
    }

    public long countTweetsWrittenIn(String... languages) {
        Criteria criteria = Criteria.where("lang").in(languages);
        return countTweets(criteria);
    }

    public long countTweetsBy(String twitterUser) {
        Criteria criteria = Criteria.where("user.name").is(twitterUser);
        return countTweets(criteria);
    }

    public long countTweetsIncluding(String hashtag) {
        Criteria criteria = Criteria.where("entities.hashtags.text").regex(hashtag, "i");
        return countTweets(criteria);
    }

    public long countTweetsByFavoritesGreaterThan(int favoriteCount) {
        Criteria criteria = Criteria.where("favorite_count").gte(favoriteCount);
        return countTweets(criteria);
    }

    public long countTweetsByRetweetsGreaterThan(int favoriteCount) {
        Criteria criteria = Criteria.where("retweet_count").gte(favoriteCount);
        return countTweets(criteria);
    }

    public int countTwitterUsers() {
        Aggregation agg = Aggregation.newAggregation(
                group("user.id"),
                group().count().as("total"));
        AggregationResults<TwitterStats> result = mongos.aggregate(agg, this.getCollectionName(), TwitterStats.class);
        TwitterStats stats = result.getMappedResults().get(0);
        return stats.getTotalTweets();
    }

    public long countUsersByFollowersGreaterThan(int followersCount) {
        Aggregation agg = Aggregation.newAggregation(
                match(Criteria.where("user.followers_count").gte(followersCount)),
                group("user.id").count().as("tweets"),
                group().count().as("total"));
        AggregationResults<TwitterStats> result = mongos.aggregate(agg, this.getCollectionName(), TwitterStats.class);
        TwitterStats stats = result.getMappedResults().get(0);
        return stats.getTotalTweets();
    }

    public AggregationResults<TwitterStats> findUsersByFollowersGreaterThan(int followersCount) {
        Aggregation agg = Aggregation.newAggregation(
                match(Criteria.where("user.followers_count").gte(followersCount)),
                group("user.id", "user.name")
                        .count().as("tweets"),
                project("name")
                        .and("id").as("_id")
                        .and("tweets").as("total"),
                sort(ASC, "name"));
        System.out.println(agg);
        AggregationResults<TwitterStats> results = mongos.aggregate(agg, this.getCollectionName(), TwitterStats.class);
        return results;
    }

    public long countTweetsByTextSearch(String text) {
        TextCriteria criteria = TextCriteria.forDefaultLanguage()
                                            .matching(text);
        Query query = TextQuery.queryText(criteria);
        return mongos.count(query, Tweet.class);
    }

    public void getCollectionIndexDetails() {
        IndexOperations indexOperations = mongos.indexOps(Tweet.class);
        List<IndexInfo> indexInfos = indexOperations.getIndexInfo();
        indexInfos.forEach(System.out::println);
    }

    public String getCollectionName() {
        return mongos.getCollectionName(Tweet.class);
    }

    public class TwitterStats {
        public Object _id;
        public String name;
        public int total;

        public String getName() {
            return name;
        }

        public Object getId() {
            return _id;
        }

        public int getTotalTweets() {
            return total;
        }

        @Override
        public String toString() {
            return "TwiiterStats{" +
                    "_id=" + _id +
                    ", name='" + name + '\'' +
                    ", total=" + total +
                    '}';
        }
    }
}
