package com.sf.boot.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by xuery on 2018/1/17.
 */
@SpringBootConfiguration
@RestController
@EnableAutoConfiguration
public class SpringSecurityAndAngularJsBasicApplication {

    @RequestMapping("resource")
    public Map<String, Object> home(String name){
        Map<String, Object> model = new HashMap<>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content","Hello xuery");
        return model;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityAndAngularJsBasicApplication.class, args);
    }
}
