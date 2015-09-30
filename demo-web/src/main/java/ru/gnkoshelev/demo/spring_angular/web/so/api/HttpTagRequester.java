package ru.gnkoshelev.demo.spring_angular.web.so.api;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * Created by kgn on 20.09.2015.
 */
public class HttpTagRequester implements TagsRequester {

    @Value(value = "${site}")
    private String site;

    private RestTemplate restTemplate;

    @Required
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getTagInfo(String tag) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.TEXT_HTML));
        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.111 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        try {
            ResponseEntity<String> response = restTemplate.exchange(String.format("http://%s/tags/%s/subscriber-info?_=%d", site, tag, DateTime.now().getMillis()), HttpMethod.GET, entity, String.class);
            if (!response.getStatusCode().is2xxSuccessful()) {
                return null;
            }
            return response.getBody();
        } catch (HttpClientErrorException exception) {
            return null;
        }
    }
}
