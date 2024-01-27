package com.jdc.cthu.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.cthu.demo.entity.State;

public interface StateRepo extends JpaRepository<State, Integer>{

}
