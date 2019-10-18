package com.cogent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="Empid")
	private Integer EmpId;
	@Column(name="EmpName")
	private String EmpName;
	@Column(name="EmpProfile")
	private String EmpProfile;
	@Column(name="EmpAddress")
	private String EmpAddress;
	@Column(name="EmpPhone")
	private String  EmpPhone;
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public String getEmpProfile() {
		return EmpProfile;
	}
	public void setEmpProfile(String empProfile) {
		EmpProfile = empProfile;
	}
	public String getEmpAddress() {
		return EmpAddress;
	}
	public void setEmpAddress(String empAddress) {
		EmpAddress = empAddress;
	}
	public String getEmpPhone() {
		return EmpPhone;
	}
	public void setEmpPhone(String empPhone) {
		EmpPhone = empPhone;
	}
	
	public Integer getEmpId() {
		return EmpId;
	}
	public void setEmpId(Integer empId) {
		EmpId = empId;
	}
	@Override
	public String toString() {
		return "Employee [EmpName=" + EmpName + ", EmpProfile=" + EmpProfile + ", EmpAddress=" + EmpAddress
				+ ", EmpPhone=" + EmpPhone + "]";
	}
	

}
