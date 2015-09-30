package ru.gnkoshelev.demo.spring_angular.web.mongo;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.annotation.Required;

/**
 * Created by kgn on 20.09.2015.
 */
public class DatastoreFactory {
    private MongoClient mongoClient;
    private Morphia morphia;
    private String dbName;

    @Required
    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @Required
    public void setMorphia(Morphia morphia) {
        this.morphia = morphia;
    }

    @Required
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public Datastore buildDatastore() {
        return morphia.createDatastore(mongoClient, dbName);
    }
}
