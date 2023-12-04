package com.example.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="user_details")
@Entity
public class UserDetails {

	
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="user_first_name")
	private String userFirstName;
	
	@Column(name="user_last_name")
	private String userLastName;
	
	@Column(name="user_mail_id")
	private String userMailId;
	
	@Column(name="user_mobile_no")
	private Long userMobileNo;
	
	@Column(name="user_dob")
	private Date userDateOfBirth;
	
	@Column(name="user_gender")
	private String userGender;
	
	@Column(name="user_country")
	private Integer userCountry;
	
	@Column(name="user_state")
	private Integer userState;
	
	@Column(name="user_city")
	private Integer userCity;
	
	@Column(name="user_password")
	private String userPassword;
	
	@Column(name="user_acc_status")
	private Boolean userAccStatus=false;
	
	@Column(name="user_created_date")
	@CreationTimestamp
	private Date userCreatedDate;
	
	@UpdateTimestamp
	@Column(name="user_updated_date")
	private Date userUpdatedDate;
	
}
