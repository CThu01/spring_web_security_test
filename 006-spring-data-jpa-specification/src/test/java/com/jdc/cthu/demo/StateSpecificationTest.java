package com.jdc.cthu.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.cthu.demo.entity.District;
import com.jdc.cthu.demo.service.DistrictSpecService;
import com.jdc.cthu.demo.service.StateCriteriaService;
import com.jdc.cthu.demo.service.StateSpecService;

@SpringBootTest
public class StateSpecificationTest {

	@Autowired
	private StateCriteriaService stateService;
	
	@Autowired
	private DistrictSpecService distService;
	
	@Autowired
	private StateSpecService stateSpecSerice;
	

	@Test
	void spec_test() {
		var result = stateService.findByRegion("East");
		
//		for(var name : result) {
//			System.out.println(name.getName());
//		}
	}
	
	@Disabled
	@Test
	void dist_spec_test() {
		var result = distService.findByRegion("East");
		for(var name : result) {
			System.out.println("%s : %s".formatted(name.getState().getName(),name.getName()));
		}
	}
	
	@Disabled
	@Test
	void dist_count_test() {
		var result = distService.countByStateName("Ayeyarwady");
		assertEquals(result, 8L);
	}
	

	@Disabled
	@Test
	void dto_Test() {
		var result = stateSpecSerice.findDtoByRegion("South");
		
		for(var list : result) {
			System.out.println("%s : %s".formatted(list.getname(),list.getRegion()));			
		}
	}
	 
	
	@Disabled
	@Test
//	@Transactional
	void root_test() {
		var result = stateSpecSerice.searchByDistrictNameLike("mo");
		System.out.println(result.toString());
	}
	
	@Disabled
	@Test
	void sub_query_test() {
		var resultList = stateSpecSerice.serachUsingSubQuery("mo");
		resultList.forEach(name -> System.out.println(name.getName()));
	}
	
	@Disabled
	@Test
	void using_or_specification() {
		var resultList = distService.criteriaBuilderUsingOr("Hpa-an");
		resultList.forEach(name -> System.out.println(name.getName()));
	}
	
	@Disabled
	@Test
	void dynamic_search_test() {
		var resultList = distService.dynamicSearch(null, null, null,"yitkyin");
		System.out.println(resultList.toString());
		resultList.forEach(name -> System.out.println(name.getName()));
	}
	
	
	
}











