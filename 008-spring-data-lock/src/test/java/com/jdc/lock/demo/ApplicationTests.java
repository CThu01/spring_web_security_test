package com.jdc.lock.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.lock.demo.entity.Account;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
class ApplicationTests {
	
	@PersistenceContext
	private EntityManager em;

	@Test
	@Transactional
	@Rollback(false)
	void contextLoads() {
		
		var account = em.find(Account.class, 1,LockModeType.WRITE);
		account.setName("Floyd");
	}

}
