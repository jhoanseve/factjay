/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wengi;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 *
 * @author jhoanseve2
 */
@Configuration
@EnableMongoRepositories
public class MongoConfiguration extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "factjay";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient();
    }

//    @Override
//    protected UserCredentials getUserCredentials() {
//        return new UserCredentials("usrelectiva", "electiva");
//    }

    @Override
    protected String getMappingBasePackage() {
        return "com.wengi.data.repository";
    }
    
}
