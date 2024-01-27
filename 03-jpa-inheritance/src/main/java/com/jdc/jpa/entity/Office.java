package com.jdc.jpa.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@DiscriminatorValue("O")
public class Office extends Account{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "isAdmin")
	private boolean isAdmin;

//	public Office(String loginId, String password, Role role) {
//		super(loginId, password, role);
//		setRole(Role.OFFICE);
//	}
	
	
	
}
