package com.jdc.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdc.jpa.entity.Account;
import com.jdc.jpa.entity.Account.Role;
import com.jdc.jpa.entity.Address;

public class CourseFeesRelation{

	private static EntityManagerFactory emf;
	private EntityManager em;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("02-jpa-relation");
	}
	
	@BeforeEach
	void createEm() {
		em = emf.createEntityManager();
	}
	
	
	@Test
	void tes1() {
		
		em.getTransaction().begin();
		
		var account = new Account();
		account.setLoginId("000998");
		account.setPassword("09Cthu3201");
		account.setRole(Role.MANAGER);
		em.persist(account);
//		em.getTransaction().commit();
		
//		em.getTransaction().begin();
		var account1 = new Account();
//		System.out.println(account1.getId());
		account1.setLoginId("000700");
		account1.setPassword("889Andrew01");
		account1.setRole(Role.ADMIN);
		em.persist(account1);
		
		var address = new Address();
		address.setAddress("No540 1st Karaweik");
		address.setPhone("+95998268832");
		address.setAccount(account1);
		em.persist(address);
		
		
		em.getTransaction().commit();
		
	}
	
	
	
	@AfterEach
	void closeEm() {
		if(null != em || em.isOpen()) {
			em.close();
		}
	}
	
	
	@AfterAll
	static void closeEmf() {
		if(null != emf || emf.isOpen()) {
			emf.close();
		}
	}
}
