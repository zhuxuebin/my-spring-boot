package com.sf.boot.myspringboot.mapper;

import com.sf.boot.myspringboot.domain.HotelDto;

import java.util.List;

public interface HotelDtoMapper {
	
	public List<HotelDto> findByCountry(String country);
}
