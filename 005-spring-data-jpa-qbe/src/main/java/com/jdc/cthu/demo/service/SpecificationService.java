package com.jdc.cthu.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jdc.cthu.demo.entity.State;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class SpecificationService {

	@PersistenceContext
	private EntityManager em;
	
	public List<State> findByRegion(String region){
		
		var builder = em.getCriteriaBuilder();
		
		var query = builder.createQuery(State.class);
		
		var root = query.from(State.class);
		
		query.select(root);
		
		var predicate = builder.equal(root.get("region"), region);
		
		query.where(predicate);
		
		return em.createQuery(query).getResultList();
	}
	
}
