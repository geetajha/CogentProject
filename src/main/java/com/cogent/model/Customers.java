package com.cogent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VCustomers")
public class Customers {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="cust_id")
	private Integer cuId;
	@Column(name="cust_name")
	private String cuName;
	@Column(name="cu_phone")
	private Integer cuPhone;
	@Column(name="cu_Add")
	private String cuAdd;
	@Column(name="cu_Email")
	private String cuEmail;
	
	
	public String getCuAdd() {
		return cuAdd;
	}
	public void setCuAdd(String cuAdd) {
		this.cuAdd = cuAdd;
	}
	public String getCuEmail() {
		return cuEmail;
	}
	public void setCuEmail(String cuEmail) {
		this.cuEmail = cuEmail;
	}
	public Integer getCuId() {
		return cuId;
	}
	public void setCuId(Integer cuId) {
		this.cuId = cuId;
	}
	public String getCuName() {
		return cuName;
	}
	public void setCuName(String cuName) {
		this.cuName = cuName;
	}
	public Integer getCuPhone() {
		return cuPhone;
	}
	public void setCuPhone(Integer cuPhone) {
		this.cuPhone = cuPhone;
	}
	
	
	
	

}
