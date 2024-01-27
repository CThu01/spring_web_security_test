package com.jdc.cthu.test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.cthu.config.ApplicationConfig;
import com.jdc.cthu.entity.State;
import com.jdc.cthu.entity.State.Type;
import com.jdc.cthu.entity.repo.StateRepo;




@SpringJUnitConfig(classes = ApplicationConfig.class)
@Sql(scripts = {
		"/init-tables.sql",
		"/insert.sql"
})
public class StateRepoTest {

	@Autowired
	private StateRepo repo;
	
	@Disabled
	@Transactional
	@ParameterizedTest
	@CsvSource({
		"State,7",
		"Region,7",
		"Union,1"
	})
	void find_by_test(Type name,long id) {
		Stream<State> result = repo.streamByType(name);
//		assertThat(result, hasSize(id));
		assertThat(result.count(), is(id));
	}
	
	@Disabled
	@ParameterizedTest
	@CsvSource({
		"State,7",
		"Region,7",
		"Union,1"
	})
	void count_test(Type type,long id) {
		var resultCount = repo.countByType(type);
		assertThat(resultCount, is(id));
	}
	
	@Disabled
	@ParameterizedTest
	@CsvSource({
		"Bago"
	})
	void exists_test(String name) {
		var resultCount = repo.existsByname(name);
		assertTrue(resultCount);;
	}
	
	
	@Disabled
	@ParameterizedTest
	@CsvSource({
		"Bago","Yangon"
	})
	void findOne_test(String name) {
		var resultCount = repo.findOneByName(name);
		assertThat(resultCount.getName(), is(name));
	}
	
	
	@Disabled
	@ParameterizedTest
	@CsvSource({
		"Lower,2",
		"Central,2"
	})
	void findFrist3_test(String name,int count) {
		var resultCount = repo.findFirst2ByRegion(name);
		assertThat(resultCount, hasSize(count));
		System.out.println(resultCount);
		for(State states : resultCount) {
			System.out.println(states.getName() + " : " + states.getRegion());
		}	
	}
	
	
	@Disabled
	@ParameterizedTest
	@CsvSource({
		"State,7",
		"Region,7",
		"Union,1"
	})
	void count_distint(Type type,long count) {
		
		long result = repo.countDistinctByType(type);
		assertThat(result, is(count));
	}
	
	
	@Disabled
	@Transactional
	@ParameterizedTest
	@CsvSource({
		"Lower,12",
		"Central,12"
	})
	void removeTest(String name,int num) {
		repo.removeByRegion(name);
		
		System.out.println(repo.countByType(Type.State));
				
	}
	
	
	@Transactional
	@ParameterizedTest
	@CsvSource({
		"State,7",
		"Region,7"
	})
	void deleteTest(Type name,int num) {
		
		int result = repo.deleteByType(name);
		
		assertThat(result, is(num));
	}
	
	
	
}




