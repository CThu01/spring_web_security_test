package com.jdc.cthu.test.namequery;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.cthu.config.ApplicationConfig;
import com.jdc.cthu.entity.repo.StateNameNativeQueryRepo;

@SpringJUnitConfig(classes = ApplicationConfig.class)
public class StateNameNativeQueryRepoTest {

	@Autowired
	StateNameNativeQueryRepo repo;
	
	@ParameterizedTest
	@CsvSource(
		"State,7"
	)
	void native_query_test(String name,int count) {
		var result = repo.stateUsingNameNativeQuery(name);
		assertThat(result, hasSize(count));
	}
	
}
