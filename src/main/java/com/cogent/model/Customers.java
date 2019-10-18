package com.cogent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customers {
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="cust_id")
	private Integer cuId;
	@Column(name="cust_name")
	private String cuName;
	@Column(name="cu_phone")
	private int cuPhone;
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
	public int getCuPhone() {
		return cuPhone;
	}
	public void setCuPhone(int cuPhone) {
		this.cuPhone = cuPhone;
	}
	

}
