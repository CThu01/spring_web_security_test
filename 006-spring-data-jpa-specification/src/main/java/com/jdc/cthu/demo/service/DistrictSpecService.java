package com.jdc.cthu.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.results.DomainResultCreationStateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jdc.cthu.demo.entity.District;
import com.jdc.cthu.demo.entity.District_;
import com.jdc.cthu.demo.entity.State_;
import com.jdc.cthu.demo.repo.DistrictRepo;

@Service
public class DistrictSpecService {
	
	
	@Autowired
	private DistrictRepo distRepo;
	
	public Specification<District> byName(String name){
		return (root,query,cb) -> cb.equal(root.get("state").get("name"), name);
	}
	
	public long countByStateName(String name) {
		return distRepo.count(byName(name));
	}

	public List<District> findByRegion(String region){
		
		Specification<District> specification = 
				(root,query,cb) -> cb.equal(root.get("state").get("region"), region); 
		
		return distRepo.findAll(specification);
	}
	
	public List<District> criteriaBuilderUsingOr(String keyword){
		
		Specification<District> spec = (root,query,cb) -> {
			
			var districtNameLike = cb.like(cb.lower(root.get(District_.name)), keyword.toLowerCase().concat("%"));
			var stateName = cb.equal(root.get(District_.state).get(State_.name), keyword.toLowerCase());
			var stateRegion = cb.equal(root.get(District_.state).get(State_.region), keyword.toLowerCase());
			var stateCapital = cb.equal(root.get(District_.state).get(State_.capital), keyword.toLowerCase());
			
			return cb.or(districtNameLike,stateName,stateRegion,stateCapital);
		};
		
		return distRepo.findAll(spec);
	}
	
	
	public List<District> dynamicSearch(String stateName,Integer stateId,String districtName,String stateCapitalKeyword){
		
		List<Specification<District>> specList = new ArrayList<Specification<District>>();
		
		if(StringUtils.hasLength(stateName)) {
			specList.add((root,query,cb) -> cb.equal(root.get(District_.state).get(State_.name), stateName));
		}
		
		if(null != stateId && stateId > 0) {
			specList.add((root,query,cb) -> cb.equal(root.get(District_.state).get(State_.id), stateId));
		}
		
		if(StringUtils.hasLength(districtName)) {
			specList.add((root,query,cb) -> cb.equal(root.get(District_.name), districtName));
		}
		
		if(StringUtils.hasLength(stateCapitalKeyword)) {
			specList.add((root,query,cb) -> 
			cb.like(cb.lower(root.get(District_.state).get(State_.capital)), 
					("%".concat(stateCapitalKeyword.toLowerCase().concat("%")))));
		}
		
		return distRepo.findAll(Specification.allOf(specList));
	}
	
	
	
}










