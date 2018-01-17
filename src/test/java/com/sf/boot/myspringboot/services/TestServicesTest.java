package com.sf.boot.myspringboot.services;

import com.sf.boot.myspringboot.MySpringBootApplication;
import com.sf.boot.myspringboot.domain.TestPOJO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by xuery on 2018/1/17.
 */
//Spring Junit支持，由此引入Spring-Test框架支持
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MySpringBootApplication.class)
public class TestServicesTest {

    @Autowired
    TestServices testServices;

    @Test
    public void testShow() {
        String expectResult = "hello world!";
        String result = testServices.show();
        Assert.assertTrue(">>>>一致", expectResult.equals(result));
    }

    @Test
    public void testShowDao() {
        int age = 26;
        List<TestPOJO> result = testServices.showDao(age);
        Assert.assertEquals(result.size(),2);
    }
}
