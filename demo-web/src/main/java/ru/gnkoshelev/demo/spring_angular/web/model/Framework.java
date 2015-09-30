package ru.gnkoshelev.demo.spring_angular.web.model;

import java.util.List;

/**
 * Created by kgn on 20.09.2015.
 */
public class Framework {
    private String name;
    private List<Tag> tags;
    private int maxFollowers;
    private int maxQuestions;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Tag> getTags() {
        return tags;
    }
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public int getMaxFollowers() {
        return maxFollowers;
    }
    public void setMaxFollowers(int maxFollowers) {
        this.maxFollowers = maxFollowers;
    }

    public int getMaxQuestions() {
        return maxQuestions;
    }
    public void setMaxQuestions(int maxQuestions) {
        this.maxQuestions = maxQuestions;
    }

}
