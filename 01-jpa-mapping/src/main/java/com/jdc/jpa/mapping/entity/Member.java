package com.jdc.jpa.mapping.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;
import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.AUTO;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Lob;
import javax.persistence.Enumerated;
import javax.persistence.Basic;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.EnumType.ORDINAL;
import static javax.persistence.EnumType.STRING;

@Entity
@Getter
@Setter
@Table(name = "member_tbl")
@SecondaryTables({
		@SecondaryTable(
				name = "contact_tbl"
//				uniqueConstraints = {
//					@UniqueConstraint(columnNames = "loginId")	
//				}
		),
		@SecondaryTable(
				name = "Login_Info",
				indexes = {
					@Index(columnList = "email")
				},
				uniqueConstraints = {
					@UniqueConstraint(columnNames = "email")
				}
		)
})
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "phoneName",nullable = false,length = 40)
	private String name;
	@Column(name = "phoneColumn",nullable = false,length = 40)
	private String phone;
	@Transient
	private String isDeleted;
	
//	@Basic(optional = false)
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column(table = "Login_Info")
//	@Basic(optional = true)
	private String address;
	@Column(table = "Login_Info")
	private String email;
	@Column(table = "Login_Info")
	@Enumerated(ORDINAL)
	private Role role;
	
	@Embedded
	private Contact contact;
	
	public enum Role{
		ADMIN,TEACHER,STUDENT
	}

	public Member() {
		
	}
	
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	public Member(String name, String phone) {
		super();
//		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
