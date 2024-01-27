package com.jdc.cthu.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.cthu.demo.repo.StateRepo;
import com.jdc.cthu.demo.service.StateCriteriaService;
import com.jdc.cthu.demo.service.StateSpecService;

@SpringBootTest
public class DeleteTest {

	@Autowired
	private StateRepo stateRepo;
	
	@Autowired
	private StateSpecService stateSpecService;
	
	@Autowired
	private StateCriteriaService stateCriService;
	
	@Disabled
	@Test
	void state_delete_test() {
		var result = stateSpecService.deleteByState("East");
		System.out.println(result);
	}
	
	@Test
	void cri_delete_test() {
		var result = stateSpecService.deleteByState("East");
		System.out.println(result);
	}
	
	
	
	
}






