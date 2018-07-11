package com.sf.boot.myspringboot.temp;


import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by xuery on 2018/5/4.
 */
public class StreamFilterDemo {

    public static void main(String[] args) {
//        List<Person> personList = new ArrayList<>();
//
//        personList.add(new Person("xuery",12,"半岛花园"));
//
//        personList.add(new Person("pj",24,"雅正"));
//
//        personList.add(new Person("james",25,"克利夫兰"));
//
//        Person person = personList.stream().filter(person1 -> person1.getName().equals("xuery")).findAny().get();
//
//        System.out.println(person);

        List<String> bagNo1 = new ArrayList<>(Arrays.asList("1","2"));
        List<String> bagNo2 = new ArrayList<>(Arrays.asList("1","2"));

        List<String> list = Collections.emptyList();
        System.out.println(list.contains("1"));
    }
}
