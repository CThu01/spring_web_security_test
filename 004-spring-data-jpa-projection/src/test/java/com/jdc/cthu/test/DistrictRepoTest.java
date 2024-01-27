package com.jdc.cthu.test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import com.jdc.cthu.config.ApplicationConfig;
import com.jdc.cthu.entity.repo.DistrictProjectionRepo;
import com.jdc.cthu.entity.repo.DistrictRepo;




@SpringJUnitConfig(classes = ApplicationConfig.class)
@Sql(scripts = {
		"/init-tables.sql",
		"/insert.sql"
})
public class DistrictRepoTest {

	@Autowired
	DistrictProjectionRepo repo;
	
	@ParameterizedTest
	@CsvSource("1,8")
	void find_test(int id,int count) {
		var result = repo.findByStateId(id);
		assertThat(result, hasSize(count));
//		assertThat(result, allOf(
//				notNullValue(),
//				hasProperty("id",is(1)),
//				hasProperty("name",is("Hinthada"))
////				hasProperty("type","Region"),
////				hasProperty("displayName","Hinthada : Region")
//				));
		
		
		
		
//		for(var res : result) {
//			System.out.println("State Name : %s".formatted(res.getName()));
//		}
		
		
	}
	
}





