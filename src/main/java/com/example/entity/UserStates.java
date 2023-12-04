package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="states_master")
public class UserStates {
	
	@Id
	//@OneToMany(cascade = CascadeType.ALL)
	@Column(name="state_id")
	private Integer stateId;
	
	@Column(name="state_name")
	private String stateName;
	
	@Column(name="country_Id")
	//@JoinColumn(name="country_id",table = "country_master")
	private String countryId;
}