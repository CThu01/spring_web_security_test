package com.jdc.jpa.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product")
@NoArgsConstructor
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name",nullable = false,length = 25)
	private String name;
	
	@Column(name = "ws_price")
	private int wsPrice;
	@Column(name = "dt_price",nullable = false)
	private int detailPrice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;
	
	@OneToMany(mappedBy = "product")
	private List<SaleDetails> sale_details;

	public Product(String name, int wsPrice, int detailPrice, Category category) {
		super();
		this.name = name;
		this.wsPrice = wsPrice;
		this.detailPrice = detailPrice;
		this.category = category;
	}

	
	
	


	
	
	
}




