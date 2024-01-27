package com.jdc.lock.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

	@Id
	private Integer id;
	
	@NonNull
	@OneToOne
	@MapsId
	@PrimaryKeyJoinColumn
	private Account account;
	
	@NonNull
	private LocalDate dob;
	private String introduction;
	private String image;
	
	@Version
	private int version;
	

}





