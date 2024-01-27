package com.jdc.cthu.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.cthu.config.ApplicationConfig;
import com.jdc.cthu.entity.District;
import com.jdc.cthu.entity.repo.DistrictRepo;

@SpringJUnitConfig(classes = ApplicationConfig.class)
@Sql(value = {
		"/init-tables.sql",
		"/insert.sql"
})
public class DistrictTest {

	@Autowired
	DistrictRepo repo;
	
	@Disabled
	@ParameterizedTest
	@CsvSource("shwe,1")
	void startwith_test(String name,int count) {
		var resultList = repo.findByNameStartingWithIgnoreCaseOrderByName(name);
		
		assertThat(resultList, hasSize(count));
		
		for(District one : resultList) {
			System.out.println(one.getName());
		}
	}
	
//	@Disabled
	@ParameterizedTest
	@CsvSource("bag,4")
	void nameLike(String name,int count) {
		var resultList = repo.findByStateNameLikeIgnoreCase(name.concat("%"));
		
//		assertThat(resultList, hasSize(count));
		
		for(District one : resultList) {
			System.out.println(one.getName());
		}
	}
	
}





