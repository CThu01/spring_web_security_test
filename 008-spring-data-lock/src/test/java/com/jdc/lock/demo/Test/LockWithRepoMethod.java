package com.jdc.lock.demo.Test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.lock.demo.repo.AccountRepo;

@SpringBootTest
public class LockWithRepoMethod {

	@Autowired
	AccountRepo repo;
	
	@Test
	@Transactional
	@Rollback(false)
	void repoTest() {
		var account = repo.findOneAndLockNoWait(1);
		
		account.setName("Updated Admin");
	}
	
	
	
}






