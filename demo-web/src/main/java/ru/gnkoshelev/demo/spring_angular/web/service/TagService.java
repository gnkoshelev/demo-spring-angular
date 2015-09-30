package ru.gnkoshelev.demo.spring_angular.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.gnkoshelev.demo.spring_angular.web.repository.TagRepository;
import ru.gnkoshelev.demo.spring_angular.web.so.api.TagsRequester;
import ru.gnkoshelev.demo.spring_angular.web.so.api.TagsParser;
import ru.gnkoshelev.demo.spring_angular.web.model.Tag;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kgn on 20.09.2015.
 */
@Service
public class TagService {
    @Autowired
    private TagsRequester requester;

    @Autowired
    private TagRepository repository;

    @Autowired
    private TagsParser parser;

    @Value(value = "${suggestedLimit}")
    private Integer limit;

    public Tag get(String name) {
        Tag tag = repository.get(name);
        if (tag != null) {
            return tag;
        }
        String rawTag = requester.getTagInfo(name);
        if (rawTag == null) {
            return null;
        }
        tag = parser.parseTag(name, rawTag);
        return tag != null ? repository.persist(tag) : null;
    }

    public List<String> suggest(String pattern) {
        List<String> suggested = repository.suggest(pattern, limit);
        return suggested;
    }

    public List<Tag> list(String[] names) {
        List<Tag> tags = repository.list(Arrays.asList(names));
        return tags;
    }
}
