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
@NamedQueries({ @NamedQuery(name = "Action.findAll", query = "SELECT ac FROM Action ac"),
		@NamedQuery(name = "Action.findByName", query = "SELECT ac FROM Action ac WHERE ac.name = :name"),
		@NamedQuery(name = "Action.findEnabledActions", query = "SELECT ac FROM Action ac WHERE ac.enable = :enable") })
@Table(name = "actionOfSystem")
public class Action {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "typeOfAction")
	private String name;
	@Column(name = "isEnable")
	private boolean enable;

	public Action() {

	}

	public Action(String name, boolean enable) {
		this.name = name;
		this.enable = enable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

}
