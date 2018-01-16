package com.sf.boot.myspringboot.mapper;

import com.sf.boot.myspringboot.domain.TestPOJO;

import java.util.List;


public interface TestMapper {
	
	public List<TestPOJO> get(Integer age);
}
