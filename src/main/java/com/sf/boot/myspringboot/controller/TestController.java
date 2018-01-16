package com.sf.boot.myspringboot.controller;

import com.sf.boot.myspringboot.services.TestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
    private TestServices testServices;
	
	@RequestMapping(value = "/show")
    public String show(){
        return testServices.show();
    }

    @RequestMapping(value = "/showDao")
    public Object showDao(int age){
        return testServices.showDao(age);
    }
    
    @RequestMapping(value = "/country/{country}")  
    public Object showDao(@PathVariable String country){
        return testServices.findByCountry(country);
    }
    
    
    
}
