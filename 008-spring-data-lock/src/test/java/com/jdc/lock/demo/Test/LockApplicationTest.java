package com.jdc.lock.demo.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.lock.demo.entity.Account;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

@SpringBootTest
public class LockApplicationTest {

	@Autowired
	EntityManager em;
	
	@Test
	@Transactional
	@Rollback(false)
	void test() {
		var account = em.find(Account.class, 1);
		
		em.lock(account, LockModeType.PESSIMISTIC_WRITE);;

		account.setName(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		
		

	}
	
	
	
}




