package com.jdc.mkt.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.mkt.entity.Category;

//@Repository
//public class CategoryRepo {
//
//	@PersistenceContext
//	EntityManager em;
//	
//	@Transactional
//	public Category create(Category cat) {
//		em.persist(cat);
//		return cat;
//	}
//}

public interface CategoryRepo extends JpaRepository<Category, Integer>{
	
}