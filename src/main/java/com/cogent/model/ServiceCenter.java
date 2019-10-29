package com.cogent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Branches")
public class ServiceCenter {
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "BranchId")
	private Integer branchId;
	@Column(name = "BranchName")
	private String branchName;
	@Column(name = "branchAddress")
	private String branchAddress;
	public Integer getBranchId() {
		return branchId;
	}
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchAddress() {
		return branchAddress;
	}
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
	@Override
	public String toString() {
		return "ServiceCenter [BranchId=" + branchId + ", branchName=" + branchName + ", branchAddress=" + branchAddress
				+ "]";
	}
	
	
	
	}

