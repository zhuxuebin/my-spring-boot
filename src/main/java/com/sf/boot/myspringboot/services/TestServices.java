package com.sf.boot.myspringboot.services;

import java.util.List;

import com.sf.boot.myspringboot.domain.HotelDto;
import com.sf.boot.myspringboot.domain.TestPOJO;
import com.sf.boot.myspringboot.mapper.HotelDtoMapper;
import com.sf.boot.myspringboot.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServices {

	@Autowired
    private TestMapper testMapper;
	
	@Autowired
    private HotelDtoMapper hotelDtoMapper;
	
	public String show(){
        return "hello world!";
    }

    public List<TestPOJO> showDao(int age){
        return testMapper.get(age);
    }
    
    public List<HotelDto> findByCountry(String country){
        return hotelDtoMapper.findByCountry(country);
    }
    
}
