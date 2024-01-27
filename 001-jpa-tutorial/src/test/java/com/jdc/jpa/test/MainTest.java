package com.jdc.jpa.test;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MainTest{

	public static EntityManagerFactory emf;
	
	@BeforeEach
	void init() {
		emf = Persistence.createEntityManagerFactory("jpa-tutorial");
	}
	
	@AfterEach
	void close() {
		if(emf != null && emf.isOpen()) {
			emf.close();
		}
	}
	
//	@Test
//	void test1() {
//		System.out.println("Testing");
//		
//	}
}
