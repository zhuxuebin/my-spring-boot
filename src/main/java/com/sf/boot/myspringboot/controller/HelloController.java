package com.sf.boot.myspringboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuery on 2018/1/5.
 */
@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/")
    public String home() {
        logger.debug("访问hello>>>>>>>>>>>>>");
        return "Hello World!!!";
    }

    @RequestMapping("/hello/{name}")
    public String helloName(@PathVariable String name) {
        logger.debug("访问helloName,name={}",name);
        return "Hello " + name;
    }
}
