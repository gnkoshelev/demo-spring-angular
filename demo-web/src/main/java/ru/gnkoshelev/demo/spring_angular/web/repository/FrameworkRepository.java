package ru.gnkoshelev.demo.spring_angular.web.repository;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.gnkoshelev.demo.spring_angular.web.model.Framework;
import ru.gnkoshelev.demo.spring_angular.web.model.Tag;

import java.util.List;

/**
 * Created by kgn on 20.09.2015.
 */
@Repository
public class FrameworkRepository {
    @Autowired
    private Datastore datastore;

    public List<Framework> list() {
        Query<Framework> query = datastore.find(Framework.class);
        return query.asList();
    }

    public Framework get(String id) {
        return datastore.get(Framework.class, id);
    }

    public Framework persist(Framework framework) {
        datastore.save(framework);
        return framework;
    }

    public Framework merge(Framework framework) {
        datastore.merge(framework);
        return framework;
    }

    public Framework removeTag(Framework framework, Tag tag) {
        UpdateOperations ops = datastore.createUpdateOperations(Framework.class);
        ops = ops.removeAll("tags", tag);
        ops = ops.set("maxFollowers", framework.getMaxFollowers());
        ops = ops.set("maxQuestions", framework.getMaxQuestions());
        UpdateResults results = datastore.update(framework, ops);
        return get(framework.getName());
    }

    public Framework addTag(Framework framework, Tag tag) {
        UpdateOperations ops = datastore.createUpdateOperations(Framework.class);
        ops = ops.add("tags", tag, false);
        ops = ops.set("maxFollowers", framework.getMaxFollowers());
        ops = ops.set("maxQuestions", framework.getMaxQuestions());
        UpdateResults results = datastore.update(framework, ops);
        return get(framework.getName());
    }

    public void remove(String id) {
        datastore.delete(Framework.class, id);
    }
}
