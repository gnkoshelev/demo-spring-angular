package ru.gnkoshelev.demo.spring_angular.web.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.annotation.Required;

import java.util.Set;

/**
 * Created by kgn on 20.09.2015.
 */
public class MongoFactory {
    private String dbHost;
    private int dbPort;
    private Set<Class> entityClasses;

    @Required
    public void setDbHost(String host) {
        this.dbHost = host;
    }

    @Required
    public void setDbPort(int port) {
        this.dbPort = port;
    }

    @Required
    public void setEntityClasses(Set<Class> entityClasses) {
        this.entityClasses = entityClasses;
    }

    public MongoClient buildMongoClient() {
        MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
        builder.sslInvalidHostNameAllowed(true);
        MongoClientOptions mongoClientOptions = builder.build();
        ServerAddress address = new ServerAddress(dbHost, dbPort);
        return new MongoClient(address, mongoClientOptions);
    }

    public Morphia buildMorphia() {
        Morphia morphia = new Morphia().map(entityClasses);
        morphia.getMapper().getConverters().addConverter(new DateTimeConverter());
        return morphia;
    }
}
