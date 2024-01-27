package com.jdc.cthu.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.cthu.demo.entity.District;
import com.jdc.cthu.demo.entity.State;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class StateCriteriaService {

	@PersistenceContext
	EntityManager entityManager;
	
	public List<District> findByRegion(String region){
		
		var builder = entityManager.getCriteriaBuilder();
		
		var criQuery = builder.createQuery(District.class);
		
		var root = criQuery.from(District.class);
		criQuery.select(root);
		criQuery.where(builder.equal(root.get("state").get("region"), region));
		
		var result = entityManager.createQuery(criQuery);
	
		return result.getResultList();
	}
	
	
	@Transactional
	public long deleteByRegion(String region) {
		
		// Create Criteria Builder
		var criteriaBuilder = entityManager.getCriteriaBuilder();
		
		deleteDistrictByRegion(region);
		
		var delete = criteriaBuilder.createCriteriaDelete(State.class);
		var root = delete.from(State.class);
		delete.where(criteriaBuilder.equal(root.get("region"), region));
		
		return entityManager.createQuery(delete).executeUpdate();
	}


	private long deleteDistrictByRegion(String region) {
		// Create Criteria Builder
		var criteriaBuilder = entityManager.getCriteriaBuilder();
		
		var delete = criteriaBuilder.createCriteriaDelete(District.class);
		var root = delete.from(District.class);
		
		// Sub Query for Select district where region
		var districtByRegion = delete.subquery(District.class);
		// select ? from District
		var subRoot = districtByRegion.from(District.class);
		// select District from District
		districtByRegion.select(subRoot);
		// join district with state
		var join = subRoot.join("state");
		// where state.region = region
		districtByRegion.where(criteriaBuilder.equal(join.get("region"), region));
		
		// We can't create predicate from related entity because root criteria delete is single root 
		// delete.where(criteriaBuilder.equal(root.get("state").get("region"), region));
		
		delete.where(root.in(districtByRegion));
		
		return entityManager.createQuery(delete).executeUpdate();
	}
	
}






