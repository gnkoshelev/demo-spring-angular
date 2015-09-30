package ru.gnkoshelev.demo.spring_angular.web.so.api;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import ru.gnkoshelev.demo.spring_angular.web.model.Tag;

import java.util.List;

/**
 * Created by kgn on 20.09.2015.
 */
@Component
public class TagsParser {
    public Tag parseTag(String name, String rawTag) {
        Tag tag = new Tag();
        tag.setName(name);
        tag.setFollowers(-1);
        tag.setQuestions(-1);

        if (rawTag == null) {
            return tag;
        }

        Document doc = Jsoup.parseBodyFragment(rawTag);

        Elements tm_sub_infos = doc.getElementsByAttributeValue("class", "tm-sub-info");
        if (!tm_sub_infos.isEmpty()) {
            Element tm_sub_info = tm_sub_infos.get(0);
            List<Node> nodes = tm_sub_info.childNodes();
            if (nodes.size() > 2) {
                int i = 0;
                Node firstNode = nodes.get(i);
                String followers = null;
                String questions = null;
                if (firstNode instanceof TextNode) {
                    String text = ((TextNode) firstNode).text();
                    int commaPos = text.indexOf(',');
                    if (commaPos != -1) {
                        followers = text.substring(0, commaPos);
                        tag.setFollowers(extractInteger(followers));
                        questions = text.substring(commaPos + 1);
                        tag.setQuestions(extractInteger(questions));
                        if (tag.getQuestions() == -1) {
                            i++;
                        }
                    } else {
                        tag.setFollowers(extractInteger(text));
                        if (tag.getFollowers() == -1) {
                            firstNode = nodes.get(++i);
                            followers = ((Element)firstNode).attr("title");
                            tag.setFollowers(extractInteger(followers));
                        }
                        i++;
                    }
                } else {
                    followers = ((Element)firstNode).attr("title");
                    tag.setFollowers(extractInteger(followers));
                    i++;
                }

                if (i != 0) {
                    Node questionsNode = nodes.get(i);
                    if (questionsNode instanceof TextNode) {
                        String text = ((TextNode) questionsNode).text();
                        int commaPos = text.indexOf(',');
                        if (commaPos != -1) {
                            questions = text.substring(commaPos + 1);
                            tag.setQuestions(extractInteger(questions));
                        } else {
                            questions = text.substring(commaPos + 1);
                            tag.setQuestions(extractInteger(questions));
                        }
                        if (tag.getQuestions() == -1) {
                            //Ищем далее
                            questions = ((Element) nodes.get(i+1)).attr("title");
                        }
                    } else {
                        questions = ((Element) questionsNode).attr("title");
                    }
                    if (tag.getQuestions() == -1) {
                        tag.setQuestions(extractInteger(questions));
                    }
                }
            }
        }

        Elements tm_descriptions = doc.getElementsByAttributeValue("class", "tm-description");
        if (!tm_descriptions.isEmpty()) {
            Element tm_description = tm_descriptions.get(0);
            tag.setDescription(tm_description.text());
        }
        return tag;
    }

    private int extractInteger(String text) {
        String value = text.replaceAll("[\\D]", "");
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            System.err.format("Cannot parse integer from text '%s'", text);
        }
        return -1;
    }
}
