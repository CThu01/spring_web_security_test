package com.jdc.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 12,nullable = false)
	private String phone;
	@Column(length = 40)
	private String email;
	@Column(length = 255,nullable = false)
	private String address;
	
	@MapsId
	@OneToOne(optional = false)
	@PrimaryKeyJoinColumn
	private Account account;
	
	

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
//		this.id = account.getId();
		this.account = account;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
