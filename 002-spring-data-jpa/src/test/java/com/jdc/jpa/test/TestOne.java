package com.jdc.jpa.test;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.jpa.config.ApplicationConfig;
import com.jdc.jpa.entity.Address;
import com.jdc.jpa.entity.Category;
import com.jdc.jpa.entity.Product;
import com.jdc.jpa.entity.SaleDetailsPk;
import com.jdc.jpa.entity.repo.AddressRepo;
import com.jdc.jpa.entity.repo.CategoryRepo;
import com.jdc.jpa.entity.repo.ProductRepo;
import com.jdc.jpa.entity.repo.SaleDetailsRepo;

@SpringJUnitConfig(classes = ApplicationConfig.class)
@Sql(scripts = {
		"/insert.sql"
})
public class TestOne{

	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	AddressRepo addressRepo;
	
	@Autowired
	SaleDetailsRepo sdRepo;
	
	@Disabled
	@ParameterizedTest
	@CsvSource("Entertainment")
	@DisplayName("01.Category Save Test")
	void test1_Save(String name) {
		
		var category = new Category(name);
		var result = categoryRepo.save(category);
		
		System.out.println(result.toString());
		assertThat(result, hasProperty("id",is(8)));
		
	}
	
	
	@Disabled
	@Test
	@DisplayName("02.findById()")
	void testFindById() {
		var resultOne = productRepo.findById(10).get();
		System.out.println(resultOne.toString());
		assertThat(resultOne, allOf(
					notNullValue(),
					hasProperty("id",is(10)),
					hasProperty("name",is("Tiger Beer")),
					hasProperty("wsPrice",is(2200)),
					hasProperty("detailPrice",is(2500))
				));
		
		System.out.println("%d\t%s\t%d\t%d\t%s"
					.formatted(resultOne.getId(),resultOne.getName(),resultOne.getWsPrice(),resultOne.getDetailPrice(),resultOne.getCategory().getName()));

	}
	
	
	@Test
	@DisplayName("03.delete test")
	@Transactional
	void testDelete() {
		
		var result = new Address(3,"19st,Between 80x81 sts", "Aungmyaytharzan", "Mandalay");
		
//		addressRepo.deleteById(3);
		
//		System.out.println(addressRepo.findAll().size());
//		assertThat(addressRepo.count(), is(4L));
		
		
		
	}
	
	

}










