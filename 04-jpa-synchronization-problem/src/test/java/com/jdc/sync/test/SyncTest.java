package com.jdc.sync.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


public class SyncTest {

	public static EntityManagerFactory emf;
	public EntityManager em;
 	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("synchronization-problem");
	}
	
	
	
	@AfterAll
	static void end() {
		if( null != emf || emf.isOpen()) {
			emf.close();
		}
	}
	
}
