package com.jdc.cthu.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import jakarta.persistence.EntityManagerFactory;

@Configuration
//@PropertySource("classpath:/connection.properties")
@ComponentScan("com.jdc.cthu.entity")
@EnableTransactionManagement
@EnableJpaRepositories("com.jdc.cthu.entity.repo")
public class ApplicationConfig {

//	@Value("${db.url}")
//	private String url;
//	@Value("${db.username}")
//	private String username;
//	@Value("${db.password}")
//	private String password;
	
	@Bean
	DataSource dataSource() {
		
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.HSQL)
				.build();
		
//		BoneCPDataSource conn = new BoneCPDataSource();
//		conn.setJdbcUrl("jdbc:mysql://localhost:3306/product_db");
//		conn.setUser("root");
//		conn.setPassword("admin");
//		
//		return conn;
	}
	
	@Bean
	FactoryBean<EntityManagerFactory> entityManagerFactory(DataSource dataSource) throws IOException{
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		
		factory.setDataSource(dataSource);
		factory.setPackagesToScan("com.jdc.cthu.entity");
		factory.setJpaProperties(mapProperty());
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return factory;
	}
	
	public Properties mapProperty() throws IOException {
		Properties pro = new Properties();
		pro.load(getClass().getResourceAsStream("/jpa.properties"));
		return pro;
	}
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
}
