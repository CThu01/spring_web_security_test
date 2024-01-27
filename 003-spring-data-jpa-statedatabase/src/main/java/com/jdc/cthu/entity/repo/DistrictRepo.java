package com.jdc.cthu.entity.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.cthu.entity.District;

public interface DistrictRepo extends JpaRepository<District, Integer>{

	List<District> findByNameStartingWithIgnoreCaseOrderByName(String name);
	
	List<District>  findByStateNameLikeIgnoreCase(String name);
}
