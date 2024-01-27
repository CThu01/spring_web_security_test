package com.jdc.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
//@DiscriminatorValue("S")
@NoArgsConstructor
public class Student extends Account{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "student_name")
	private String name;
	
//	@OneToOne
//	private Address address;
	
//	@ManyToMany
//	@Column(name = "section")
//	private List<Section> sections;

//	public Student(String loginId, String password, Role role) {
//		super(loginId, password, role);
		
//	}


	
	
	
	
}
