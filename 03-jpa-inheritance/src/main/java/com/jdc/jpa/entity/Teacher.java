package com.jdc.jpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@DiscriminatorValue("T")
public class Teacher extends Account{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "teacher_name")
	private String name;
	
//	@OneToMany(mappedBy = "teacher")
//	@Column(name = "class")
//	private List<Section> section;

//	public Teacher(String loginId, String password, Role role) {
//		super(loginId, password, role);
//		setRole(Role.TEACHER);
//	}
	
	
	
}
