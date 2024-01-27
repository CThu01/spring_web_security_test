package com.jdc.cthu.entity.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jdc.cthu.entity.State;
import com.jdc.cthu.entity.projection.StateIdNameSizeDtoInf;

public interface StateProjectionWithQueryAnnotationRepo extends JpaRepository<State, Integer>{

	@Query("""
			select s.id,s.name,size(s.district) districtCount from State s 
			where s.region=:region
			""")
	List<StateIdNameSizeDtoInf> countDistrictInRegionJpql(@Param("region") String name);
	
	@Query(
			nativeQuery = true,
			value = """
			select s.id,s.name,count(d.state_id) districtCount from state s 
			join district d on d.state_id=s.id where s.region=?1 group by s.id,s.name
			""")
	List<StateIdNameSizeDtoInf> countDistrictInRegionNative(String name);
	
}
