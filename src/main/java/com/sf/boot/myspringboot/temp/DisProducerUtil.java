package com.sf.boot.myspringboot.temp;

import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述：
 *
 * @author 01368080
 * @date 2018/6/11
 */
public class DisProducerUtil {

    private static Map<String,String> producerStrMap = new ConcurrentHashMap<>();

    public static String getByKey(String key){
        String producerStrValue = producerStrMap.get(key);
        if(StringUtils.isEmpty(producerStrValue)){
            producerStrValue = "@#1";
            producerStrMap.put(key,producerStrValue);
        }
        return producerStrValue;
    }
}
