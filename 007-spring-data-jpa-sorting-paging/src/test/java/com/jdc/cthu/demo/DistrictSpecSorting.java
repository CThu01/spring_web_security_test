package com.jdc.cthu.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import com.jdc.cthu.demo.entity.District;
import com.jdc.cthu.demo.service.DistrictSortingService;

@SpringBootTest
public class DistrictSpecSorting {

	@Autowired
	DistrictSortingService distService;
	
	@Disabled
	@Test
	void order_spec_test() {
		var resultList = distService.findSpecByStateName("Yangon",Sort.by("name"));
		resultList.forEach(name -> System.out.println(name.getName()));
	}
	
//	@Disabled
	@Test
	void sortType_test() {
		var typeSort = Sort.sort(District.class);
		var resultList = distService.findSpecByStateName("Yangon", typeSort.by(District::getName).descending());
		
		resultList.forEach(name -> System.out.println("Yangon Districts : "+name.getName()));
	}
	
}
