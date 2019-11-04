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
	private Integer empId;
	@Column(name="EmpName")
	private String empName;
	@Column(name="EmpProfile")
	private String empProfile;
	@Column(name="EmpAddress")
	private String empAddress;
	@Column(name="EmpPhone")
	private String  empPhone;
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpProfile() {
		return empProfile;
	}
	public void setEmpProfile(String empProfile) {
		this.empProfile = empProfile;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public String getEmpPhone() {
		return empPhone;
	}
	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empProfile=" + empProfile + ", empAddress="
				+ empAddress + ", empPhone=" + empPhone + "]";
	}
	
	

}
