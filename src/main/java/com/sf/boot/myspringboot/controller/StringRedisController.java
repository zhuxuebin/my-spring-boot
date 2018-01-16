package com.sf.boot.myspringboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by xuery on 2018/1/16.
 */
@RestController
public class StringRedisController {

    private static final Logger logger = LoggerFactory.getLogger(StringRedisController.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource(name="stringRedisTemplate")
    ValueOperations<String, String> valOprStr;

    @RequestMapping("set")
    public String setKeyAndValue(String key, String value){
        logger.debug("访问set:key={},value={}",key,value);
        valOprStr.set(key, value);
        return "set ok";
    }

    @RequestMapping("get")
    public String getKey(String key){
        logger.debug("访问get:key={}",key);
        return valOprStr.get(key);
    }
}
