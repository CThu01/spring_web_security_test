package com.jdc.cthu.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import com.jdc.cthu.demo.repo.DistrictRepo;

@SpringBootTest
public class DistrictSortingTest {

	@Autowired
	DistrictRepo distRepo;
	 
	@Test
	void naming_rule_test() {
		var resultList = distRepo.searchStateRegionCustomOrder("Lower",Sort.by("name").descending());
		resultList.forEach(result -> System.out.println(result.getName()));
	}
	
}
