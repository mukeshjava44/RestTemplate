package com.mukesh.kb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "addressTab")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	@Column(name = "mohalla")
	private String mohalla;
	@Column(name = "village")
	private String village;
	@Column(name = "roadName")
	private String roadName;
	@Column(name = "policeStation")
	private String policestation;
	@Column(name = "district")
	private String district;
	@Column(name = "state")
	private String state;
	@Column(name = "pincode")
	private int pinCode;

}
