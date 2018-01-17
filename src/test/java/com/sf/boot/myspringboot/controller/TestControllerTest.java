package com.sf.boot.myspringboot.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sf.boot.myspringboot.MySpringBootApplication;
import com.sf.boot.myspringboot.domain.TestPOJO;
import com.sf.boot.myspringboot.services.TestServices;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * Created by xuery on 2018/1/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MySpringBootApplication.class)
public class TestControllerTest {

    MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    private TestServices testServices;

    String expectedJson;

    @Before
    public void setup() throws Exception{
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testShow() throws Exception {
        String expectedResult = "hello world!";
        String uri = "/show";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertTrue("数据一致",status == 200 && expectedResult.equals(content));
    }

    @Test
    public void testShowDao() throws Exception{
        List<TestPOJO> testPOJOS = testServices.showDao(26);
        expectedJson = obj2Json(testPOJOS);

        String uri = "/showDao?age=26";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertTrue("数据一致", status == 200 && expectedJson.equals(content));
    }

    private String obj2Json(Object obj) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }
}
