package ru.gnkoshelev.demo.spring_angular.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.gnkoshelev.demo.spring_angular.web.model.Framework;
import ru.gnkoshelev.demo.spring_angular.web.service.FrameworkService;

import java.util.List;

/**
 * Created by kgn on 20.09.2015.
 */
@Controller
@RequestMapping("/api/frameworks")
public class FrameworkController {
    @Autowired
    private FrameworkService frameworkService;

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Framework> list() {
        return frameworkService.list();
    }

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Framework create(@RequestParam String name, @RequestParam(required = false) String tagNames) {
        Framework framework = frameworkService.create(name, tagNames != null ? tagNames.split(" ") : new String[0]);
        return framework;
    }

    @ResponseBody
    @RequestMapping(value = "/addTag", method = RequestMethod.POST)
    public Framework addTag(@RequestParam String id, @RequestParam String name) {
        return frameworkService.addTag(id, name);
    }

    @ResponseBody
    @RequestMapping(value = "/removeTag", method = RequestMethod.POST)
    public Framework removeTag(@RequestParam String id, @RequestParam String name) {
        return frameworkService.removeTag(id, name);
    }

    @ResponseBody
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public void remove(@RequestParam String id) {
        frameworkService.remove(id);
    }
}
