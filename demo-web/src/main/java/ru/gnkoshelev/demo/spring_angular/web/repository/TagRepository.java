package ru.gnkoshelev.demo.spring_angular.web.repository;

import org.joda.time.DateTime;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.gnkoshelev.demo.spring_angular.web.model.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kgn on 30.09.2015.
 */
@Repository
public class TagRepository {
    @Autowired
    private Datastore datastore;

    public List<String> suggest(String pattern, int limit) {
        Query<Tag> query = datastore.createQuery(Tag.class);
        query.field("name").contains(pattern);
        query.order("-questions");
        query.retrievedFields(true, "name");
        query.limit(limit);
        List<Tag> tags = query.asList();
        List<String> suggested = new ArrayList<String>(tags.size());
        for (Tag tag : tags) {
            suggested.add(tag.getName());
        }
        return suggested;
    }

    public Tag get(String name) {
        return datastore.get(Tag.class, name);
    }

    public List<Tag> list(List<String> names) {
        return datastore.get(Tag.class, names).asList();
    }

    public Tag persist(Tag tag) {
        tag.setUpdatedAt(DateTime.now());
        datastore.save(tag);
        return tag;
    }
}
