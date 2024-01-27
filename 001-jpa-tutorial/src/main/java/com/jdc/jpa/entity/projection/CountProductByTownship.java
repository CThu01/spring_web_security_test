package com.jdc.jpa.entity.projection;

public record CountProductByTownship(
		String addressName,
		String productName,
		int wsprice,
		int quantity,
		long totalPrice
		) {

}
