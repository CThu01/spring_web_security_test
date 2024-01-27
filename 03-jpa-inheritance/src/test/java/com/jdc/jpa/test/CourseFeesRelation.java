package com.jdc.jpa.test;

import java.awt.Color;

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
import com.jdc.jpa.entity.Student;
import com.jdc.jpa.entity.Teacher;

public class CourseFeesRelation{

	private static EntityManagerFactory emf;
	private EntityManager em;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("jpa-inheritance");
	}
	
	@BeforeEach
	void createEm() {
		em = emf.createEntityManager();
	}
//	
	
	@Test
	void tes1() {
		
		em.getTransaction().begin();
		
		
////		
//		Account account = new Student("Andrew","andrew@123",Role.STUDENT);
////		account.setLoginId("000998");
////		account.setPassword("09Cthu3201");
////		account.setRole(Role.OFFICE);
////		((Student) account).setName("Mr.Andrew");
//		em.persist(account);
//////		em.getTransaction().commit();
////		
//////		em.getTransaction().begin();
//		Account account1 = new Teacher("Floyd","Floyd@123",Role.TEACHER);
//////		System.out.println(account1.getId());
////		account1.setLoginId("000700");
////		account1.setPassword("889Andrew01");
////		account1.setRole(Role.ADMIN);
////		((Teacher) account1).setName("Mr.Floyd");
//		em.persist(account1);
////		
//		Account account2 = new Student("Charles","Charles@213989",Role.STUDENT);
////		address.setAddress("No540 1st Karaweik");
////		address.setPhone("+95998268832");
////		address.setAccount(account1);
////		((Student) account).setName("Mr.Charles");
//		em.persist(account2);
		
		
		var account = new Account("Andrew","andrew@123",Role.STUDENT,Color.DARK_GRAY);
		em.persist(account);
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
