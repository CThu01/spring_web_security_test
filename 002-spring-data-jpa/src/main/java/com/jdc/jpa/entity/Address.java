package com.jdc.jpa.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "address")
@NoArgsConstructor
public class Address implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,length = 255)
	private String street;
	@Column(length = 255)
	private String township;
	@Column(length = 255)
	private String city;

	@OneToOne(mappedBy = "address")
	private Customer customer;

	public Address(int id,String street, String township, String city) {
		super();
		this.id = id;
		this.street = street;
		this.township = township;
		this.city = city;
	}
	
	
}




