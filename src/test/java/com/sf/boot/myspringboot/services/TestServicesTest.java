package com.sf.boot.myspringboot.services;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sf.boot.myspringboot.MySpringBootApplication;
import com.sf.boot.myspringboot.domain.TestPOJO;
import com.sf.boot.myspringboot.temp.DisProducerUtil;
import com.sf.boot.myspringboot.temp.RuleItem;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by xuery on 2018/1/17.
 */
//Spring Junit支持，由此引入Spring-Test框架支持
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MySpringBootApplication.class)
public class TestServicesTest {

    @Autowired
    private TestServices testServices;

    @Autowired
    private MybatisComplexQueryServices mybatisComplexQueryServices;

    @Autowired
    private RemoteService remoteService;

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

    @Test
    public void testStreamSorted(){
        RuleItem ruleItem = new RuleItem("rule2",2);
        RuleItem ruleItem1 = new RuleItem("rule2",1);
        RuleItem ruleItem2 = new RuleItem("rule2",3);
        List<RuleItem> ruleItems = Arrays.asList(ruleItem, ruleItem1, ruleItem2);
        ruleItems = ruleItems.stream().sorted(Comparator.comparingInt(RuleItem::getIndex)).collect(Collectors.toList());
        System.out.println(ruleItems);
    }

    @Test
    public void testJson(){
        String jsonStr = "{\"createEmpCode\":\"999999\",\"sysSource\":\"O2O_DDS_TEST\"}";
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        Map<String,Object> map = jsonObject.getInnerMap();
        System.out.println();
    }

    @Test
    public void testMyBatisComplexQueryServices(){
        mybatisComplexQueryServices.queryAllDisConfByOneQuery(57159319669571584L);
    }

    @Test
    public void testProducerUtil(){
        for(int i=0;i<3;i++)
            DisProducerUtil.getByKey("prod1");
        System.out.println(String.valueOf("11"));
    }

    @Test
    public void testRetry(){
        try {
            remoteService.retryByApi();
        } catch (Exception e){

        }
    }

    @Test
    public void testCircuitBreaker() throws Exception{
        remoteService.circuitBreakerRetry();
        remoteService.circuitBreakerRetry();
        remoteService.circuitBreakerRetry();
        remoteService.circuitBreakerRetry();
    }

    @Test
    public void testCircuitBreaker2() throws Exception{
        String s1 = remoteService.myCircuitBreaker();
        String s2 = remoteService.myCircuitBreaker();
        String s3 = remoteService.myCircuitBreaker();
        String s4 = remoteService.myCircuitBreaker();

        Thread.sleep(1001);
        String s5 = remoteService.myCircuitBreaker();
        Thread.sleep(1001);
        String s6 = remoteService.myCircuitBreaker();
        String s7 = remoteService.myCircuitBreaker();
        String s8 = remoteService.myCircuitBreaker();
    }
}
