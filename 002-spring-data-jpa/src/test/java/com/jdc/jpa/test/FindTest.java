package com.jdc.jpa.test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.jpa.config.ApplicationConfig;
import com.jdc.jpa.entity.Product;
import com.jdc.jpa.entity.repo.ProductRepo;

import jakarta.transaction.Transactional;

@SpringJUnitConfig(classes = ApplicationConfig.class)
@Sql(scripts = "/insert.sql")
public class FindTest {

	@Autowired
	ProductRepo productRepo;
	
	@Disabled
	@Test
	@Transactional
	void testOne() {
		
		List<Product> productList = productRepo.findAll();
		
		System.out.println(productList.toString());
		for(Product p : productList) {
			System.out.println("%s\t %s\t %s\t %s\t"
					.formatted(p.getId(),p.getName(),String.valueOf(p.getDetailPrice()),String.valueOf(p.getWsPrice())));
		}
		assertThat(productList, allOf(
					notNullValue(),
					hasSize(32)
				));
	}
	
//	@Disabled
	@ParameterizedTest
	@CsvSource("10")
	@Transactional
	void testTwo(int id) {
		
		var product = productRepo.findById(id).get();
		assertThat(product.getId(), is(id));
		assertThat(product, allOf(
					hasProperty("id",is(id)),
					hasProperty("name",is("Tiger Beer"))
				));
		
		System.out.println("%d\t%s\t%d\t%d\t%s".
				formatted(product.getId(),product.getName(),product.getWsPrice(),product.getDetailPrice(),product.getCategory().getName()));
	}
	
	@Disabled
	@ParameterizedTest
	@CsvSource("10")
	@Transactional
	void testThree(int id) {
		
		var product = productRepo.getReferenceById(id);
		System.out.println(product.toString());
		System.out.println(product.getName());
	}
	
	
}




