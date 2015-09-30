package ru.gnkoshelev.demo.spring_angular.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.gnkoshelev.demo.spring_angular.web.model.Tag;
import ru.gnkoshelev.demo.spring_angular.web.service.TagService;

import java.util.List;

/**
 * Created by kgn on 20.09.2015.
 */
@Controller
@RequestMapping("/api/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @ResponseBody
    @RequestMapping(value = "/suggest", method = RequestMethod.GET)
    public List<String> suggest(@RequestParam(required = true) String pattern) {
        return tagService.suggest(pattern);
    }

    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Tag get(@RequestParam(required = true) String name) {
        return tagService.get(name);
    }

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Tag> list(@RequestParam(required = true) String names) {
        return tagService.list(names.split(" "));
    }
}
