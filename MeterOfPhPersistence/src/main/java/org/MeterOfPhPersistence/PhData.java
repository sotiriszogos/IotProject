package org.MeterOfPhPersistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phdata")
public class PhData {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="date")
	private String date;
	@Column(name="time")
	private String time;
	@Column(name="ph")
	private double ph;
	
	public PhData() {
	}
	
	public PhData (double ph, String date, String time) {
		this.ph = ph;
		this.date = date;
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getPh() {
		return ph;
	}

	public void setPh(double ph) {
		this.ph = ph;
	}
	
	
}
