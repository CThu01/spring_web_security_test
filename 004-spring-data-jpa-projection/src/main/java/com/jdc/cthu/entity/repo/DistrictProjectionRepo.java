package com.jdc.cthu.entity.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.cthu.entity.District;
import com.jdc.cthu.entity.projection.DistrictDtoInf;

public interface DistrictProjectionRepo extends JpaRepository<District, Integer>{

	List<DistrictDtoInf> findByStateId(int id);
}
