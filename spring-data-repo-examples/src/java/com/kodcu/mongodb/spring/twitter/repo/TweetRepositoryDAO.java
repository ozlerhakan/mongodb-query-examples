package com.kodcu.mongodb.spring.twitter.repo;

import com.kodcu.mongodb.spring.twitter.db.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.IndexOperations;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.index.IndexInfo;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

/**
 * Created by Hakan on 4/27/2015.
 */
public class TweetRepositoryDAO implements TweetDAO {

    private final MongoOperations mongos;

    @Autowired
    public TweetRepositoryDAO(final MongoOperations mongos) {
        this.mongos = mongos;
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
