package com.jdc.lock.demo.Test;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.lock.demo.entity.Account;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
public class LockTimeOutDemo {

	@PersistenceContext
	EntityManager em;
	
	@Test
	@Transactional
	@Rollback(false)
	void timeOut() {
		
		var account = em.find(Account.class, 1);
		
		em.lock(
				account, 
				LockModeType.PESSIMISTIC_WRITE, 
				Map.of("jakarta.psersistence.lock.timeout","0")   // timeout=0 (is not working as ".. for update no wait")
			);
		
		
		
	}
	
	
	
	
}










