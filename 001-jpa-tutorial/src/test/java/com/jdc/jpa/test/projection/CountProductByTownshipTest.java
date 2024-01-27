package com.jdc.jpa.test.projection;

import org.junit.jupiter.api.Test;

import com.jdc.jpa.entity.projection.CountProductByTownship;
import com.jdc.jpa.test.MainTest;

public class CountProductByTownshipTest extends MainTest{

	@Test
	void testCount() {
		
		var em = emf.createEntityManager();
		
		var queryStmt = """
				select new com.jdc.jpa.entity.projection.CountProductByTownship(
				a.township,p.name,p.wsPrice,sd.quantity,sum(p.wsPrice*sd.quantity)
				) from SaleDetails sd 
				join sd.sale.customer.address a join sd.product p group by a.township,p.name,p.wsPrice,sd.quantity
				""";
		
		var mapByQuery = """
				select new com.jdc.jpa.entity.projection.CountProductByTownship(a.township,p.name,p.wsPrice,sd.quantity,sum(p.wsPrice*sd.quantity)) 
				from address a join a.customer.sale.sale_details sd join sd.product p group by a.township,p.name,p.wsPrice,sd.quantity
				""";
		var query = em.createQuery(mapByQuery,CountProductByTownship.class);
		var resultList = query.getResultList();
		System.out.println(resultList);
		
		for(CountProductByTownship countProduct : resultList) {
			System.out.println(countProduct);
		}
		
		System.out.println("----------------------------------------");
		for(CountProductByTownship countProdut : resultList) {
			System.out.println("%s\t%s\t%d\t%d\t%d".
					formatted(countProdut.addressName(),countProdut.productName(),countProdut.wsprice(),countProdut.quantity(),countProdut.totalPrice()));
		}
	}
	
}
