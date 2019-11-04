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
@Table(name="Vehicles")
public class VehicleRegistration {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="V_ID")
	private Integer vId;
	@Column(name="V_Number")
	private int vNum;
	@Column(name="Brand")
	private String vBrand;
	@Column(name="W_Start_Date")
	private Date wsDate;
	@Column(name="W_End_Date")
	private Date weDate;
	
	
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	//@JoinColumn(name = "custs_cust_id")
    private Customers custs;
	
		public Customers getCusts() {
			
		return custs;
		//Integer custs_cust_id = custs.getCuId();
	}

		public Integer getvId() {
			return vId;
		}

		public void setvId(Integer vId) {
			this.vId = vId;
		}

		public Integer getvNum() {
			return vNum;
		}

		public void setvNum(Integer vNum) {
			this.vNum = vNum;
		}

		public String getvBrand() {
			return vBrand;
		}

		public void setvBrand(String vBrand) {
			this.vBrand = vBrand;
		}

		public Date getWsDate() {
			return wsDate;
		}

		public void setWsDate(Date wsDate) {
			this.wsDate = wsDate;
		}

		public Date getWeDate() {
			return weDate;
		}

		public void setWeDate(Date weDate) {
			this.weDate = weDate;
		}

		public void setCusts(Customers custs) {
			this.custs = custs;
		}

		@Override
		public String toString() {
			return "VehicleRegistration [vId=" + vId + ", vNum=" + vNum + ", vBrand=" + vBrand + ", wsDate=" + wsDate
					+ ", weDate=" + weDate + ", custs=" + custs + "]";
		}
		
		
	
	
	
	
	
	

}
