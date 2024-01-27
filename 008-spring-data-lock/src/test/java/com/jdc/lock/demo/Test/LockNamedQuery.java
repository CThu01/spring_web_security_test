package com.jdc.lock.demo.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.lock.demo.entity.Account;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
public class LockNamedQuery {

	@PersistenceContext
	EntityManager em;
	
	@Test
	@Transactional
	@Rollback(false)
	void nameQueryTest() {
		
		var query = em.createNamedQuery("Account.findByRole",Account.class);
		query.setParameter(1, "aungaung@gmail.com");
		
		var result = query.getResultList();
		if(!result.isEmpty()) {
			result.get(0).setName(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
			System.err.println("Before update");
		}
	}
}
