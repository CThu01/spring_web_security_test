package com.jdc.jpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import jakarta.persistence.NamedQuery;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product")
@NamedQuery(
		name = "Product.selectProduct",
		query = """
				select p from product p
				"""
		)
@NamedQuery(
		name = "Product.count",
		query = """
				select count(p) from product p
				"""
		)
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
	
	@ManyToOne
	private Category category;
	
	@OneToMany(mappedBy = "product")
	private List<SaleDetails> sale_details;


	
	
	
}




