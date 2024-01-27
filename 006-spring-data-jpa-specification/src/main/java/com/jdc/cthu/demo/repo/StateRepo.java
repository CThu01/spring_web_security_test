package com.jdc.cthu.demo.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.cthu.demo.entity.State;

public interface StateRepo extends JpaRepositoryImplementation<State, Integer>{

	public long deleteByRegion(String region);
}
