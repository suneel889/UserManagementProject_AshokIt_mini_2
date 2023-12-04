package com.example.bindings;

import java.util.Date;

import lombok.Data;

@Data
public class UserDetails {
	

	private Integer userId;
	private String userFirstName;
	private String userLastName;
	private String userMailId;
	private Long userMobileNo;
	private Date userDateOfBirth;
	private String userGender;
	private Integer userCountry;
	private Integer userState;
	private Integer userCity;
	

}
