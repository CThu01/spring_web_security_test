package com.jdc.jpa.entity;

import java.awt.Color;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.jdc.jpa.converter.ColorConverter;
import com.jdc.jpa.embadable.Contact;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;

@Entity
@Table(name = "account")
@Getter
@Setter
//@MappedSuperclass
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
//@DiscriminatorColumn(name = "entity-name"/* ,columnDefinition = "char(1)" *//*discriminatorType = DiscriminatorType.INTEGER*/)
public class Account implements Serializable{

	 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false,length = 10)
	private String loginId;
	
	@Column(nullable = false,length = 40)
	private String password;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Convert(converter = ColorConverter.class)
	private Color color;
	
	private Contact contact;
	
	@AttributeOverrides({
			@AttributeOverride(
					name = "phone", 
					column = @Column(name = "sec_phone", length = 14/*
																								 * ,columnDefinition =
																								 * "sec_phone like '09%'"
																								 */
					)),
			@AttributeOverride(
					name = "email", 
					column = @Column(name = "sec_email"/*
																					 * ,columnDefinition =
																					 * "sec_email like '%@%'"
																					 */
					))
	})
	private Contact secondaryContact;
	
//	@OneToOne(mappedBy = "account")
//	private Address address;
	
	
	public Account(String loginId, String password, Role role,Color color) {
		super();
		this.loginId = loginId;
		this.password = password;
		this.role = role;
		this.color = color;
	}

//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}

	public enum Role{
		TEACHER,STUDENT,OFFICE,ADMIN
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
