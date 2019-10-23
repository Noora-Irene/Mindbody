package com.strong.mindbody.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Power {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long powerId;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "power")
	private List<Note> notes;
	
	public Power() {}

	public Power(String name) {
		super();
		this.name = name;
	}

	public long getPowerId() {
		return powerId;
	}

	public void setPowerId(long powerId) {
		this.powerId = powerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "Power [powerId=" + powerId + ", name=" + name + "]";
	}
	
}
