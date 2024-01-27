package com.jdc.cthu.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.cthu.demo.service.LocationService;

@SpringBootTest
public class FetchableFlutentTest {

	@Autowired
	LocationService service;
	
	@Disabled
	@Test
	@Transactional
	void test_fetchable_flutent() {
		var result = service.findRegionAsStream("East");
		assertNotNull(result);
		assertEquals(2L, result.count());
	}
	
	@Test
	void test_bynamic_search() {
		
		var result = service.dynamicSearch(1, null , "m");
		
//		assertThat(result,hasSize(8));
		System.out.println(result.size());
		for(var name : result) {
			System.out.println("%s : %s".formatted(name.getState().getName(),name.getName()));
		}
		
		
	}
	
	
}



