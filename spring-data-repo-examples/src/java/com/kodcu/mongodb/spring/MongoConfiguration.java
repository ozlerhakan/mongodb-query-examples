package com.kodcu.mongodb.spring;

import com.kodcu.mongodb.spring.twitter.repo.TweetRepository;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Hakan on 4/27/2015.
 */
@EnableMongoRepositories(basePackageClasses = TweetRepository.class, repositoryImplementationPostfix="DAO")
class MongoConfiguration extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "twitter";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(new ServerAddress("localhost", 27017));
    }
}
