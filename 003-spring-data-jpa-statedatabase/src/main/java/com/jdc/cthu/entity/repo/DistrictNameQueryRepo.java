package com.jdc.cthu.entity.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jdc.cthu.entity.District;
import com.jdc.cthu.entity.State.Type;

public interface DistrictNameQueryRepo extends JpaRepository<District, Integer>{

	@Query(name = "District.findWithNameQuery")
	List<District> findForNameQuery(Type type,String name);
	
	@Query(value = "select d from District d where d.state.id=:id")
	List<District> jpqlQueryAnnotation(@Param("id") int id);
	
	@Query(nativeQuery = true,
			value = """
			select * from district where state_id=:id
			""")
	List<District> nativeQueryAnnotation(@Param("id") int id);
}
