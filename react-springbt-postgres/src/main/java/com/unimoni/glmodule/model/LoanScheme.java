package com.unimoni.glmodule.model;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LoanSchemes")
public class LoanScheme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long schemeId;
	
	@Column(name="scheme_name")
	private String schemeName;
	
	@Column(name="interest_rate")
	private double interestRate;
	
	@Column(name="tenure")
	private String tenure;
	
	@Column(name="addDate")
	private LocalDateTime addDate;
	
	@Column(name="modDate")
	private LocalDateTime modDate;

	public Long getSchemeId() {
		return schemeId;
	}

	public LocalDateTime getModDate() {
		return modDate;
	}

	public void setModDate(LocalDateTime localDateTime) {
		this.modDate = localDateTime;
	}

	public LocalDateTime getAddDate() {
		return addDate;
	}

	public void setAddDate(LocalDateTime localDateTime) {
		this.addDate = localDateTime;
	}

	public void setSchemeId(Long schemeId) {
		this.schemeId = schemeId;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public String getTenure() {
		return tenure;
	}

	public void setTenure(String tenure) {
		this.tenure = tenure;
	}

	@Override
	public String toString() {
		return "LoanScheme [schemeId=" + schemeId + ", schemeName=" + schemeName + ", interestRate=" + interestRate
				+ ", tenure=" + tenure + ", addDate=" + addDate + ", modDate=" + modDate + "]";
	}
	
}
