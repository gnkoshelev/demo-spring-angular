package ru.gnkoshelev.demo.spring_angular.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kgn on 20.09.2015.
 */
@Controller
@RequestMapping("/")
public class RootController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/partials/**", method = RequestMethod.GET)
    public String partial(Model model, HttpServletRequest request) {
        String partial = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        partial = partial.replace("..", "");
        return partial;
    }
}
