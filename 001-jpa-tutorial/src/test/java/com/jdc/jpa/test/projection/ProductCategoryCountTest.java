package com.jdc.jpa.test.projection;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.jdc.jpa.entity.projection.CategoryCount;
import com.jdc.jpa.test.MainTest;

public class ProductCategoryCountTest extends MainTest{

	@Test
	void projectionTest() {
		
		var em = emf.createEntityManager();
		
		var queryStmt = """
				select new com.jdc.jpa.entity.projection.CategoryCount(c.name,count(p.id)) from Product p
				join p.category c group by c.name 
				""";
		
		var query = em.createQuery(queryStmt,CategoryCount.class);
		
		var countList = query.getResultList();
//		System.out.println(countList);
		
		for(CategoryCount num : countList) {
			System.out.println("%s\t%d".formatted(num.name(),num.count()));
		}
	}
	
	
}
