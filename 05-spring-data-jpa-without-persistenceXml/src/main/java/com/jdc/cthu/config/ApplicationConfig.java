package com.jdc.cthu.config;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@ComponentScan(basePackages = "com.jdc.cthu")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.jdc.cthu.repo")
public class ApplicationConfig {

	@Bean
	DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.HSQL)
				.build();
	}
	
	@Bean
	FactoryBean<EntityManagerFactory> entityManagerFactory(DataSource dataSource) throws IOException{
		
		var factory = new LocalContainerEntityManagerFactoryBean();
		
		factory.setDataSource(dataSource);
		factory.setPackagesToScan("com.jdc.cthu.entity");
		factory.setJpaProperties(mapProperties());
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		
		return factory;
	}

	
	
	@Bean
	PlatformTransactionManager trasaction(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
	private Properties mapProperties() throws IOException {
		var pro = new Properties();
		pro.load(getClass().getResourceAsStream("/jpa.properties"));
		return pro;
	}
	
}
