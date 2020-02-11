package org.MeterOfPhPersistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "PhData.findAll", query = "SELECT ph FROM PhData ph"),
		@NamedQuery(name = "PhData.findByDate", query = "SELECT ph FROM PhData ph WHERE ph.date = :date"),
		@NamedQuery(name = "PhData.findByPhValue", query = "SELECT ph FROM PhData ph WHERE ph.ph = :ph") })
@Table(name = "phdata")
public class PhData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "dateOfMeasure")
	private String date;
	@Column(name = "timeOfMeasure")
	private String time;
	@Column(name = "ph")
	private double ph;

	public PhData() {
	}

	public PhData(double ph, String date, String time) {
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
