package ru.gnkoshelev.demo.spring_angular.web.so.api.mock;

import org.springframework.beans.factory.annotation.Required;
import ru.gnkoshelev.demo.spring_angular.web.so.api.TagsRequester;

import java.util.Map;

/**
 * Created by kgn on 20.09.2015.
 */
public class MockTagRequester implements TagsRequester {
    Map<String, String> samples;

    @Required
    public void setSamples(Map<String, String> samples) {
        this.samples = samples;
    }

    @Override
    public String getTagInfo(String tag) {
        return samples.get(tag);
    }
}
