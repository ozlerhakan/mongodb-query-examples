package com.kodcu.mongodb.spring;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

/**
 * Created by Hakan on 4/27/2015.
 */
@Configuration
@ComponentScan(basePackages = "com.kodcu.mongodb.spring")
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
