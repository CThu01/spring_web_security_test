package com.jdc.cthu.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.jdc.cthu.demo.repo.DistrictRepo;

@SpringBootTest
public class DistrictPageableTest {

	@Autowired
	DistrictRepo distRepo;
	
	@Test
	void paging_test() {
		var pageParam = PageRequest.of(1, 5, Sort.by("name"));
		var result = distRepo.findByStateRegion("Lower", pageParam);
		
		System.out.println(result);
	}
	
}
