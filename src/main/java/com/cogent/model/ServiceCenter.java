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
	@Column(name = "BranchManagerName")
	private String BranchManagerName;
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
	public String getBranchManagerName() {
		return BranchManagerName;
	}
	public void setBranchManagerName(String branchManagerName) {
		BranchManagerName = branchManagerName;
	}
	@Override
	public String toString() {
		return "ServiceCenter [BranchId=" + BranchId + ", BranchName=" + BranchName + ", BranchManagerName="
				+ BranchManagerName + "]";
	}
	public ServiceCenter(String branchName, String branchManagerName) {
		super();
		BranchName = branchName;
		BranchManagerName = branchManagerName;
	}
	public ServiceCenter() {
		super();
	}
}
