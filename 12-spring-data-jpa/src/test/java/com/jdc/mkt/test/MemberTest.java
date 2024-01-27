package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.config.ApplicationConfig;
import com.jdc.mkt.entity.Member;
import com.jdc.mkt.repo.MemberRepo;


@SpringJUnitConfig(classes = ApplicationConfig.class)
public class MemberTest {

	private static EntityManagerFactory emf;
	
	// Spring ORM
	@Autowired
	private MemberRepo memberRepo;

	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("SPRING-DATA");
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/member-values.properties", delimiter = ':')
	void test1(String name, String dob, String loginId, String password, String email, int id) throws ParseException {
		
		var df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = df.parse(dob);
		
		
		// Normal Style
//		var em = emf.createEntityManager();
//		em.getTransaction().begin();
//		var member = new Member(name, d, loginId, password, email);
//		em.persist(member);
//		System.out.println("Member id : %d".formatted(member.getId()));
//		em.getTransaction().commit();
//		em.close();
//		assertThat(member, allOf(hasProperty("id", is(id)), hasProperty("name", is(name))));
		
		
		
		// Spring ORM
		var member = new Member(name, d, loginId, password, email);
		memberRepo.create(member);
//		assertEquals("Andrew", member.getName());
		
		

	}

	@AfterAll
	static void close() {
		if (null != emf || emf.isOpen()) {
			emf.close();
		}
	}

}



