package com.sf.boot.myspringboot.services;

import com.alibaba.fastjson.JSON;
import com.sf.boot.myspringboot.mapper.DisConfMapper;
import com.sf.sgs.drds.model.AllDisConf;
import com.sf.sgs.drds.model.DisProducer;
import com.sf.boot.myspringboot.mapper.DisProducerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/6/11
 */
@Service
public class MybatisComplexQueryServices {


    @Autowired
    private DisProducerMapper disProducerMapper;

    @Autowired
    private DisConfMapper disConfMapper;

    public void queryAllDisConfByOneQuery(Long configId) {

        AllDisConf allDisConf = disConfMapper.selectRelByPrimaryKey(configId);

//        List<DisProducer> disProducers = disProducerMapper.selectByConfigId(configId);
        System.out.println(JSON.toJSONString(allDisConf));
    }
}
