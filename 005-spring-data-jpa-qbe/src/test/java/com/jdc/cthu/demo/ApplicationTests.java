package com.jdc.cthu.demo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import com.jdc.cthu.demo.entity.District;
import com.jdc.cthu.demo.entity.State;
import com.jdc.cthu.demo.repo.DistrictRepo;
import com.jdc.cthu.demo.repo.StateRepo;

@SpringBootTest
class ApplicationTests {

	@Autowired
	StateRepo stateRepo;
	
	@Autowired
	DistrictRepo distRepo;

	@Disabled
	@Test
	void qbeStateTest() {

		var probe = new State();
		probe.setRegion("East");

		var example = Example.of(probe,
				ExampleMatcher.matching()
				.withIgnorePaths("id", "porpulation")
				.withIgnoreNullValues());

		var list = stateRepo.findAll(example);

		assertThat(list, hasSize(2));
	}
	
	
	@Test
	void qbeDistrictTest() {
		
		var probe = new District();
		probe.setState(new State("South"));
		
		
		var example = Example.of(probe,
					ExampleMatcher.matching()
					.withIgnorePaths("state.id","state.porpulation")
					.withIgnoreCase()
					.withIgnoreNullValues()
				);
		
		var list = distRepo.findAll(example);
		
		assertThat(list, hasSize(9));
		
		System.out.println(list.size());
		for(var name : list) {
			System.out.println("name : %s".formatted(name.getName()));
		}
		
	}
	

}





