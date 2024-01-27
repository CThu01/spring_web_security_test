package com.jdc.cthu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.geo.Distance;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.cthu.demo.dto.StateDto;
import com.jdc.cthu.demo.dto.StateLikeNameDto;
import com.jdc.cthu.demo.entity.District;
import com.jdc.cthu.demo.entity.District_;
import com.jdc.cthu.demo.entity.State;
import com.jdc.cthu.demo.entity.State_;
import com.jdc.cthu.demo.repo.DistrictRepo;
import com.jdc.cthu.demo.repo.StateRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.JoinType;

@Service
public class StateSpecService {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	StateRepo stateRepo;
	
	@Autowired
	DistrictRepo distRepo;
	

	
	
	public List<State> serachUsingSubQuery(String name){
		
		Specification<State> spec = (root,query,cb) -> {
			var subQuery = query.subquery(Integer.class);
			var district = subQuery.from(District.class);
			subQuery.select(district.get(District_.state).get(State_.id));
			subQuery.where(
						cb.like(cb.lower(district.get(District_.name)), name.toLowerCase().concat("%"))
					);
			return root.get(State_.id).in(subQuery);
		};
		
		return stateRepo.findAll(spec);
	}
	
	
	public List<State> searchByDistrictNameLike(String name){
		
		Specification<State> spec = (root,query,cb) -> {
			var join = root.join("district",JoinType.INNER);
			return cb.like(cb.lower(join.get("name")), name.toLowerCase().concat("%"));
		};
		return stateRepo.findAll(spec);
	}
	
	
	@Transactional
	public long deleteRegion(String region) {
		return stateRepo.deleteByRegion(region);
	}
	
	public Specification<State> byRegion(String region){
		return (root,query,cb) -> cb.equal(root.get("region"), region);
	}
	
	@Transactional
	public long deleteByState(String region) {
		
		deleteByDistrict(region);
		
		var deleteResult = stateRepo.delete(byRegion(region));
		return deleteResult;
	}
	
	private long deleteByDistrict(String region) {
		
		Specification<District> specification = 
				(root,query,cb) -> cb.equal(root.get("state").get("region"), region);
		
		var deleteResult = distRepo.delete(specification);
		return deleteResult;
	}
	
	
//	Projection
	public List<StateDto> findDtoByRegion(String region){
		return stateRepo.findBy(byRegion(region), 
				query -> query
				.project("id","name","region")
				.as(StateDto.class).all()
				);
	}
	
}








