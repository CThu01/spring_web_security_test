package com.jdc.cthu.entity.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.jdc.cthu.entity.State;

public interface StateNameNativeQueryRepo extends JpaRepository<State, Integer>{

	@Query(nativeQuery = true)
	List<State> stateUsingNameNativeQuery(String name);
}

