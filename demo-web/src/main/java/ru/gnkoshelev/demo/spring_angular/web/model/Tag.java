package ru.gnkoshelev.demo.spring_angular.web.model;

import org.joda.time.DateTime;

/**
 * Created by kgn on 20.09.2015.
 */
public class Tag {
    private String name;
    private int followers;
    private int questions;
    private String description;
    private DateTime updatedAt;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getFollowers() {
        return followers;
    }
    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getQuestions() {
        return questions;
    }
    public void setQuestions(int questions) {
        this.questions = questions;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public DateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(DateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
