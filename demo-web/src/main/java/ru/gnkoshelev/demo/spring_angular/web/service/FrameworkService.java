package ru.gnkoshelev.demo.spring_angular.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gnkoshelev.demo.spring_angular.web.model.Framework;
import ru.gnkoshelev.demo.spring_angular.web.repository.FrameworkRepository;
import ru.gnkoshelev.demo.spring_angular.web.model.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kgn on 20.09.2015.
 */
@Service
public class FrameworkService {
    @Autowired
    private FrameworkRepository repository;

    @Autowired
    private TagService tagService;

    public List<Framework> list() {
        return repository.list();
    }

    public Framework get(String id) {
        return repository.get(id);
    }

    public Framework create(String name, String[] tagNames) {
        Framework framework = new Framework();
        framework.setName(name);

        int maxFollowers = 0;
        int maxQuestions = 0;
        if (tagNames != null) {
            framework.setTags(new ArrayList<Tag>(tagNames.length));
            for (String tagName : tagNames) {
                Tag tag = tagService.get(tagName);
                if (tag == null) {
                    continue;
                }
                if (maxFollowers < tag.getFollowers()) {
                    maxFollowers = tag.getFollowers();
                }
                if (maxQuestions < tag.getQuestions()) {
                    maxQuestions = tag.getQuestions();
                }
                framework.getTags().add(tag);
            }
        }
        framework.setMaxFollowers(maxFollowers);
        framework.setMaxQuestions(maxQuestions);

        framework = repository.persist(framework);
        return framework;
    }

    public Framework addTag(String id, String name) {
        Framework framework = repository.get(id);
        Tag tag = tagService.get(name);
        if (tag == null) {
            return framework;
        }
        if (tag.getFollowers() > framework.getMaxFollowers()) {
            framework.setMaxFollowers(tag.getFollowers());
        }
        if (tag.getQuestions() > framework.getMaxQuestions()) {
            framework.setMaxQuestions(tag.getQuestions());
        }
        framework = repository.addTag(framework, tag);
        return framework;
    }

    public Framework removeTag(String id, String name) {
        Framework framework = repository.get(id);
        Tag tag = tagService.get(name);
        framework = repository.removeTag(framework, tag);
        return framework;
    }

    public void remove(String id) {
        repository.remove(id);
    }
}
