package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="country_master")
public class UserCountries {
	
	@Id
	//@OneToMany(cascade = CascadeType.ALL)
	@Column(name="country_id")
	private Integer countryId;
	
	@Column(name="country_name")
	private String countryName;
	
	
}
