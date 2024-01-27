package com.jdc.jpa.test;

import org.junit.jupiter.api.Test;

import com.jdc.jpa.entity.Customer;
import com.jdc.jpa.entity.Product;

public class FindTest extends MainTest{

	@Test
	void testOne() {
		
		var em = emf.createEntityManager();
		
		var cus = em.getReference(Customer.class, 8);
		System.out.println("Product Name : " + cus.getName());
//		System.out.println("Category Name : %s".formatted(cus.getAddress().getStreet()));
	}
	
	
	
	
}




