package com.sf.boot.myspringboot.controller;

import com.sf.boot.myspringboot.dao.PersonDao;
import com.sf.boot.myspringboot.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuery on 2018/1/16.
 */
@RestController
public class ObjectRedisController {
    protected static Logger logger= LoggerFactory.getLogger(ObjectRedisController.class);

    @Autowired
    PersonDao personDao;

    @RequestMapping("/setPerson")
    public void set(String id,String name,Integer age){
        logger.debug("访问setPerson:id={},name={},age={}",id,name,age);
        Person person=new Person(id,name,age);
        personDao.save(person);
    }

    @RequestMapping("/getPerson")
    public Person getPerson(String id){
        return personDao.getPerson(id);
    }
}
