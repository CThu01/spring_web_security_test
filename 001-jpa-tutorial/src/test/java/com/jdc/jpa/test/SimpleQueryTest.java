package com.jdc.jpa.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.jpa.entity.Category;

import jakarta.persistence.EntityManager;

public class SimpleQueryTest extends MainTest{

	@Test
	void testOne() {
		
		var em = emf.createEntityManager();
		
		// getSingleResult
		var query = em.createQuery("""
				select count(c) from Category c
				""",Long.class);
		
		var result = query.getSingleResult();
		System.out.println(result);
		
		// getResultStream
		var selectQuery = em.createQuery("""
				select c from Category c
				""",Category.class);
		
		var resultStream = selectQuery.getResultStream();
		resultStream.forEach(a -> System.out.println(a.getName()));
		
	}
	
	@ParameterizedTest
	@CsvSource({
		"Butter Cake,1",
		"Noddle,9"
	})
	void updateTest(String name,int id) {
		var em = emf.createEntityManager();
		
		var query = em.createQuery("""
				update Product p set p.name = :name where p.id = :id
				""");
		
		em.getTransaction().begin();
		query.setParameter("name", name);
		query.setParameter("id", id);
		
		var updateResult = query.executeUpdate();
		em.getTransaction().commit();
		System.out.println("updateResult : %d".formatted(updateResult));

	}
	
	
	
	
}
