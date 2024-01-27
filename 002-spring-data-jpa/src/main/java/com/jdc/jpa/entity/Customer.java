package com.jdc.jpa.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customer")
public class Customer implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,length = 25)
	private String name;
	@Column(nullable = false,length = 15)
	private String phone;
	@Column(nullable = false,length = 40)
	private String email;
	
	@OneToMany(mappedBy = "customer")
	private List<Sale> sale;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Address address;
	
}




