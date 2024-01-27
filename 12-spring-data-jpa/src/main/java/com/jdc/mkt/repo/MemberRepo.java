package com.jdc.mkt.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.mkt.entity.Member;

@Repository
public class MemberRepo {

	@PersistenceContext
	private EntityManager emf;
	
	@Transactional
	public Member create(Member mem) {
		emf.persist(mem);
		return mem;
	}
}
