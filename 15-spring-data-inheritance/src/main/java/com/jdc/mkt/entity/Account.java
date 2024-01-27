package com.jdc.mkt.entity;

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

import com.jdc.mkt.AttributeConverter.ColorConverter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
//@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "acc_type",discriminatorType = DiscriminatorType.CHAR)
public class Account implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(columnDefinition = "varcahar(40) not null")
	private String name;
	@Column(nullable = false,unique = true,length = 20)
	private String loginId;
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Convert(converter = ColorConverter.class)
	private Color color;
	
	public enum Role{
		STUDENT,TEACHER,OFFICE
	}

	public Account(String name, String loginId, String password) {
		super();
		this.name = name;
		this.loginId = loginId;
		this.password = password;
	}
	
	

}



