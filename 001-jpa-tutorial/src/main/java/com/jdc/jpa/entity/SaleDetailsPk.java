package com.jdc.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class SaleDetailsPk implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "product_id")
	private int productId;
	@Column(name = "sales_id")
	private int salesId;
	
	public SaleDetailsPk() {
		super();
	}

	public SaleDetailsPk(int productId, int salesId) {
		super();
		this.productId = productId;
		this.salesId = salesId;
	}


	

}
