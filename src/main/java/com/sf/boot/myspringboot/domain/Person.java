package com.sf.boot.myspringboot.domain;

import java.io.Serializable;

/**
 * Created by xuery on 2018/1/16.
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -1657554749601539951L;

    private String id;
    private String name;
    private Integer age;

    public Person(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
