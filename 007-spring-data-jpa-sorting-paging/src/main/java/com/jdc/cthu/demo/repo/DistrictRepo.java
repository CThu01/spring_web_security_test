package com.jdc.cthu.demo.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.jdc.cthu.demo.entity.District;

public interface DistrictRepo extends JpaRepository<District, Integer>,JpaSpecificationExecutor<District>{

	// Sorting
	List<District> findByStateRegionOrderByName(String region);
	
	// Sorting
	@Query("""
			select d from District d where d.state.region=?1 order by d.name desc
			""")
	List<District> searchStateRegionWithNameQuery(String region);
	
	// Sorting
	@Query("""
			select d from District d where d.state.region=?1
			""")
	List<District> searchStateRegionCustomOrder(String region,Sort sort);
	
	// Paging
	List<District> findByStateRegion(String region,Pageable pageable);
}






















