package com.jdc.cthu.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.cthu.config.ApplicationConfig;
import com.jdc.cthu.entity.repo.StateProjectionWithQueryAnnotationRepo;

@SpringJUnitConfig(classes = ApplicationConfig.class)
public class StateProjectionWithQueryAnnotationTest {

	@Autowired
	StateProjectionWithQueryAnnotationRepo repo;
	
	@ParameterizedTest
	@CsvSource("Central,3")
	void test(String region,int count) {
		var result = repo.countDistrictInRegionNative(region);
		assertThat(result, hasSize(count));
	}
}
