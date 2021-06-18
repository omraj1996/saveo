package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="medicine")
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "c_name")
	private String name;
	
	@Column(name = "c_batch_no")
	private String batchNumber;
	
	@Column(name = "d_expiry_date")
	private String expiryDate;
	
	@Column(name = "n_balance_qty")
	private String balanceQuantity;
	
	@Column(name = "c_packaging")
	private String packaging;
	
	
	@Column(name = "c_unique_code")
	private Long uniqueCode;
	
	@Column(name = "c_schemes")
	private String schemes;
	
	@Column(name = "n_mrp")
	private double mrp;
	
	@Column(name = "c_manufacturer")
	private String manufacturer;
	
	@Column(name = "hsn_code")
	private String hsnCode;

	public Medicine(String name, String batchNumber, String expiryDate, String balanceQuantity, String packaging,
			Long uniqueCode, String schemes, double mrp, String manufacturer,String hsnCode) {
		//super();
		this.name = name;
		this.batchNumber = batchNumber;
		this.expiryDate = expiryDate;
		this.balanceQuantity = balanceQuantity;
		this.packaging = packaging;
		this.uniqueCode = uniqueCode;
		this.schemes = schemes;
		this.mrp = mrp;
		this.manufacturer = manufacturer;
		this.hsnCode=hsnCode;
	}
	
	public Medicine() {}

	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getBalanceQuantity() {
		return balanceQuantity;
	}

	public void setBalanceQuantity(String balanceQuantity) {
		this.balanceQuantity = balanceQuantity;
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	public Long getUniqueCode() {
		return uniqueCode;
	}

	public void setUniqueCode(Long uniqueCode) {
		this.uniqueCode = uniqueCode;
	}

	public String getSchemes() {
		return schemes;
	}

	public void setSchemes(String schemes) {
		this.schemes = schemes;
	}

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + name + ", batchNumber=" + batchNumber + ", expiryDate=" + expiryDate
				+ ", balanceQuantity=" + balanceQuantity + ", packaging=" + packaging + ", uniqueCode=" + uniqueCode
				+ ", schemes=" + schemes + ", mrp=" + mrp + ", manufacturer=" + manufacturer + ", hsnCode=" + hsnCode
				+ "]";
	}

	

	
	
	
	

}
