package com.jdc.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "sale_details")
public class SaleDetails implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SaleDetailsPk saleDetailsPk;

	@Column(name = "qty",nullable = false)
	private int quantity;
	@Column(name = "is_hs",columnDefinition = "boolean not null default true")
	private boolean isHs;
	private int total;
	
	@ManyToOne
	@JoinColumn(name = "product_id",insertable = false,updatable = false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "sales_id",insertable = false,updatable = false)
	private Sale sale;

	public SaleDetails() {
		super();
	}

	public SaleDetails(SaleDetailsPk saleDetailsPk, int quantity, boolean isHs, int total, Product product, Sale sale) {
		super();
		this.saleDetailsPk = new SaleDetailsPk(product.getId(),sale.getId());
		this.quantity = quantity;
		this.isHs = isHs;
		this.total = total;
		this.product = product;
		this.sale = sale;
	}

	
}







