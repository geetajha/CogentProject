package com.cogent.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="VehicleR")
public class VehicleRegistration {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="V_ID")
	private Integer vid;
	@Column(name="V_Number")
	private int vnum;
	@Column(name="Brand")
	private String brand;
	@Column(name="W_Start_Date")
	private Date wsdate;
	@Column(name="W_End_Date")
	private Date wedate;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
    private Customers custs;
	
	
	
	
	
	
	
	
	
	
	
	//@JoinColumn(name = "v_cu_Id",referencedColumnName="cust_id")
	
	
	
	
	
	
	
	
	
	
	
	public Customers getCusts() {
		return custs;
	}
	public void setCusts(Customers custs) {
		this.custs = custs;
	}
	public Integer getVid() {
		return vid;
	}
	public void setVid(Integer vid) {
		this.vid = vid;
	}
	public int getVnum() {
		return vnum;
	}
	public void setVnum(int vnum) {
		this.vnum = vnum;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Date getWsdate() {
		return wsdate;
	}
	public void setWsdate(Date wsdate) {
		this.wsdate = wsdate;
	}
	public Date getWedate() {
		return wedate;
	}
	public void setWedate(Date wedate) {
		this.wedate = wedate;
	}
	
	
	
	
	
	

}
