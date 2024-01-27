package com.jdc.cthu.test.namequery;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.cthu.config.ApplicationConfig;
import com.jdc.cthu.entity.District;
import com.jdc.cthu.entity.State.Type;
import com.jdc.cthu.entity.repo.DistrictNameQueryRepo;

@SpringJUnitConfig(classes = ApplicationConfig.class)
public class DistructNameQueryRepoTest {
	
	@Autowired
	DistrictNameQueryRepo repo;

	@Disabled
	@ParameterizedTest
	@CsvSource(
		"Region,ma,4"	
		)
	void find_name_query_test(Type type,String name,int count) {
		var result = repo.findForNameQuery(type, name.concat("%"));
		assertThat(result, hasSize(count));
	}
	
	@Disabled
	@ParameterizedTest
	@CsvSource(
			"13,15"
	)
	void query_annotation(int id,int count) {
		var result = repo.jpqlQueryAnnotation(id);
		assertThat(result, hasSize(count));
		result.forEach(a -> System.out.println(a.getName()));
	}
	
	
	@ParameterizedTest
	@CsvSource({
		"1,8",
		"2,4",
		"3,4"
	})
	void native_query_annotation(int id,int count) {
		var result = repo.nativeQueryAnnotation(id);
		assertThat(result, hasSize(count));
	}
	
	
}










