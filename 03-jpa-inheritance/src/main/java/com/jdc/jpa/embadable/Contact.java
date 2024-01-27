package com.jdc.jpa.embadable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Contact implements Serializable{

	
	private String phone;
	private String email;
}
