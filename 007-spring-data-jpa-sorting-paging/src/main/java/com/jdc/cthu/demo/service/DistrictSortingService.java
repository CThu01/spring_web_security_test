package com.jdc.cthu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.jdc.cthu.demo.entity.District;
import com.jdc.cthu.demo.entity.District_;
import com.jdc.cthu.demo.entity.State_;
import com.jdc.cthu.demo.repo.DistrictRepo;

@Service
public class DistrictSortingService {

	@Autowired
	DistrictRepo distRepo;
	
	// Sorting
	public List<District> findSpecByStateName(String capital){
		
		Specification<District> spec = (root,query,cb) -> {
			query.orderBy(cb.desc(root.get(District_.name)));
			return cb.equal(root.get(District_.state).get(State_.capital), capital);
		};
		return distRepo.findAll(spec);
	}
	
	public List<District> findSpecByStateName(String name,Sort sort){
		Specification<District> spec = (root,query,cb) -> cb.equal(root.get(District_.state).get(State_.name), name);
		
		return distRepo.findBy(spec, query -> query.sortBy(sort).all());
	}

	
	// Paging
	
	
}

















