package com.jdc.sync.test;

import javax.persistence.EntityManagerFactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.sync.entity.Account;
import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

public class ThreadTest extends SyncTest{

//	private EntityManagerFactory emf;
	
	@Test
	void createTest() {
		
		var operation1 = getThreadOne();
		var operation2 = getThreadTwo();
		
		operation1.start();
		operation2.start();
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private Thread getThreadOne() {
		return new Thread(
				() -> {
			
					System.out.println("Start Operation1");
					var em = emf.createEntityManager();
					var account = em.find(Account.class, 1);
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					em.getTransaction().begin();
					
					System.out.println("Before Operation1, Balance of %s : %d".formatted(account.getName(),account.getBalance()));
					
					account.setBalance(account.getBalance() + 100000);
					
					em.flush();
					System.out.println("After Operation1, Balance of %s : %d".formatted(account.getName(),account.getBalance()));
					
					em.getTransaction().commit();
					
				}
			);
	}
	
	private Thread getThreadTwo() {
		return new Thread(
				() -> {
					
					System.out.println("Start Operation2");
					var em = emf.createEntityManager();
					var account = em.find(Account.class, 1);
					
					System.out.println("start2 thread....");
					
					try {
						Thread.sleep(800);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					em.getTransaction().begin();
					
					System.out.println("Before Operation2, Balance of %s : %d".formatted(account.getName(),account.getBalance()));
					
					em.refresh(account);
					System.out.println("After Operation2, Balance of %s : %d (refresh) ".formatted(account.getName(),account.getBalance()));
					account.setBalance(account.getBalance() - 50000);
					System.out.println("After Operation2, Balance of %s : %d".formatted(account.getName(),account.getBalance()));
					
					em.getTransaction().commit();
				}
				
			);
	}
	
	
}
