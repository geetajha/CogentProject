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
	private Integer BranchId;
	@Column(name = "BranchName")
	private String BranchName;
	
	public Integer getBranchId() {
		return BranchId;
	}
	public void setBranchId(Integer branchId) {
		BranchId = branchId;
	}
	public String getBranchName() {
		return BranchName;
	}
	public void setBranchName(String branchName) {
		BranchName = branchName;
	}
	
	
	
	@Override
	public String toString() {
		return "ServiceCenter [BranchId=" + BranchId + ", BranchName=" + BranchName + "]";
	}
	
	public ServiceCenter(Integer branchId, String branchName) {
		super();
		BranchId = branchId;
		BranchName = branchName;
	}
	public ServiceCenter() {
		super();
	}
}
