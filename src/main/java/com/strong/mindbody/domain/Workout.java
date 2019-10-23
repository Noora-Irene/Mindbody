package com.strong.mindbody.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Workout {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long workoutId;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "workout")
	private List<Note> notes;
	
	public Workout() {}

	public Workout(String name) {
		super();
		this.name = name;
	}

	public long getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(long workoutId) {
		this.workoutId = workoutId;
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
		return "Workout [workoutId=" + workoutId + ", name=" + name + "]";
	}
		
}
