package com.jdc.jpa.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.jpa.entity.Customer;
import com.jdc.jpa.entity.Product;

public class NamedQueryTest extends MainTest{

//	@Test
//	void testOne() {
//		var em = emf.createEntityManager();
//		
//		var query = em.createNamedQuery("Product.selectProduct",Product.class);
//		
//		List<Product> productList = query.getResultList();
//		
//		for(Product p : productList) {
//			System.out.println("product Name : " + p.getName());
//		}
//		
//	}
	
	
	@ParameterizedTest
	@CsvSource(
			"a,02"
		)
	void testTwo(String name,String num) {
		
		var em = emf.createEntityManager();
		var queryString = "select cus from Customer cus where name like :name and phone like :phone";
		
		var query = em.createQuery(queryString,Customer.class);
		query.setParameter("name", name.concat("%"));
		query.setParameter("phone",num.concat("%"));
		
		
		List<Customer> customerList = query.getResultList();
		for(Customer c : customerList) {
			System.out.println("%s\t%s".formatted(c.getName(),c.getPhone()));
		}
		
	}
	
}





