package org.MeterOfPhPersistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
<<<<<<< Updated upstream
@Table (name = "action")
=======
@NamedQueries({ @NamedQuery(name = "Action.findAll", query = "SELECT ac FROM Action ac"),
		@NamedQuery(name = "Action.findByName", query = "SELECT ac FROM Action ac WHERE ac.name = :name"),
		@NamedQuery(name = "Action.findById", query = "SELECT ac FROM Action ac WHERE ac.id = :id"),
		@NamedQuery(name = "Action.findEnabledActions", query = "SELECT ac FROM Action ac WHERE ac.enable = true") })
@Table(name = "actionOfSystem")
>>>>>>> Stashed changes
public class Action {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="enable")
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
