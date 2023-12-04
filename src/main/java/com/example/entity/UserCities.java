package com.example.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cities_master")
public class UserCities {
	
	@Id
	@Column(name="city_id")
	private Integer cityId;
	
	@Column(name="city_name")
	private String cityName;
	
	@Column(name="states_Id")
	//@JoinColumn(name="city_id",table = "state_master")
	private String stateId;
}
