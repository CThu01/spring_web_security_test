package com.jdc.jpa.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.jpa.mapping.entity.Member;

public class MemberTest {
	
	static EntityManagerFactory emf;
	
	@BeforeAll
	static void init() {
		emf=Persistence.createEntityManagerFactory("01-jpa-mapping"); 
	}
	
	@AfterAll
	static void close() {
		if( null != emf || emf.isOpen()) {
			emf.close();
		}
		
	}
	
	@ParameterizedTest
	@CsvSource(value = "Andrew:+29391923",delimiter = ':')
	void test1(String name,String phone) {
		
		var member = new Member(name, phone);
		
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(member);
		em.getTransaction().commit();
		em.close();
	}
	
	
	
	
	
}
