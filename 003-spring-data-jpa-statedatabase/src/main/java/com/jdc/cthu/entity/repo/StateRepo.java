package com.jdc.cthu.entity.repo;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.cthu.entity.State;
import com.jdc.cthu.entity.State.Type;

public interface StateRepo extends JpaRepository<State, Integer>{

	
	Stream<State> streamByType(Type type);
	
	long countByType(Type type);
	
	Boolean existsByname(String name);
	
	State findOneByName(String name);
	
	List<State> findFirst2ByRegion(String name);
	
	long countDistinctByType(Type type);
	
	int removeByRegion(String region);
	
	int deleteByType(Type type);
	
}
