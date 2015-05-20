package com.kodcu.mongodb.driver;

import com.mongodb.Block;
import com.mongodb.MongoNamespace;
import com.mongodb.client.ListIndexesIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Hakan on 5/2/2015.
 */
class TweetDAOImp implements TweetDAO {

    private final MongoCollection<Document> tweets;

    public TweetDAOImp(MongoDatabase twitter) {
        this.tweets = twitter.getCollection("tweets");
    }

    private long countTweets(Document criteria) {
        return tweets.count(criteria);
    }

    @Override
    public Document findTweetBy(String id) {
        Document search = new Document("_id", new ObjectId(id));
        return tweets.find(search).first();
    }

    @Override
    public long countTweetsByVerifiedUsers() {
        Document search = new Document("user.verified", true);
        return countTweets(search);
    }

    @Override
    public long countTweetsWrittenIn(String language) {
        Document search = new Document("lang", language);
        return countTweets(search);
    }

    @Override
    public long countTweetsWrittenIn(String... languages) {
        Document search = new Document("lang", new Document("$in", asList(languages)));
        return countTweets(search);
    }

    @Override
    public long countTweetsBy(String twitterUser) {
        Document users = new Document("user.name", twitterUser);
        return countTweets(users);
    }

    @Override
    public int countTwitterUsers() {
        List<Document> pipeline;
        pipeline = asList(new Document("$group", new Document("_id", "$user.id")),
                          new Document("$group", new Document("_id", null).append("count", new Document("$sum", 1))));
        List<Document> list = tweets.aggregate(pipeline).into(new ArrayList<>());
        return list.get(0).getInteger("count");
    }

    @Override
    public long countUsersByFollowersGreaterThan(int followersCount) {
        List<Document> list = this.findUsersByFollowersGreaterThan(followersCount);
        return list.size();
    }

    @Override
    public List<Document> findUsersByFollowersGreaterThan(int followersCount) {
        List<Document> pipeline;
        pipeline = asList(new Document("$match", new Document("user.followers_count", new Document("$gte", followersCount))),
                          new Document("$group", new Document("_id", new Document("id", "$user.id").append("name", "$user.name"))
                                                      .append("tweets", new Document("$sum", 1))),
                          new Document("$project", new Document("_id","$_id.id")
                                                        .append("name", "$_id.name")
                                                        .append("total", "$tweets")),
                          new Document("$sort", new Document("name", 1)));
        List<Document> list = tweets.aggregate(pipeline).into(new ArrayList<>());
        return list;
    }

    @Override
    public String getCollectionName() {
        MongoNamespace mn = tweets.getNamespace();
        return mn.getCollectionName();
    }

    @Override
    public void getCollectionIndexDetails() {
        ListIndexesIterable<Document> indices = tweets.listIndexes();
        indices.forEach((Block<? super Document>) document -> {
            System.out.println(document);
        });
    }

    @Override
    public long countTweetsByTextSearch(String text) {
        Document fullTextSearch = new Document("$text", new Document("$search", text));
        return countTweets(fullTextSearch);
    }

    @Override
    public long countTweetsByFavoritesGreaterThan(int nOfUsers) {
        Document tweets = new Document("favorite_count", new Document("$gte", nOfUsers));
        return countTweets(tweets);
    }

    @Override
    public long countTweetsByRetweetsGreaterThan(int nOfUsers) {
        Document tweets = new Document("retweet_count", new Document("$gte", nOfUsers));
        return countTweets(tweets);
    }

    @Override
    public long countTweetsIncluding(String hashtag) {
        Document tweets = new Document("entities.hashtags.text",new Document("$regex", hashtag).append("$options", "i"));
        return countTweets(tweets);
    }
}
