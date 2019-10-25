package com.strong.mindbody.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Note {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private double date;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "workoutId")
    private Workout workout;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "powerId")
    private Power power;
	
	private int wow, time, kcal;
	
	public Note() {}

	public Note(int wow, double date, Workout workout, Power power, int time, int kcal) {
		super();
		this.wow = wow;
		this.date = date;
		this.workout = workout;
		this.power = power;
		this.time = time;
		this.kcal = kcal;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getWow() {
		return wow;
	}

	public void setWow(int wow) {
		this.wow = wow;
	}

	public double getDate() {
		return date;
	}

	public void setDate(double date) {
		this.date = date;
	}

	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}

	public Power getPower() {
		return power;
	}

	public void setPower(Power power) {
		this.power = power;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	@Override
	public String toString() {
		return "Note [wow=" + wow + ", date=" + date + ", workout=" + workout +" , power=" + power +" time=" + time + ", kcal=" + kcal + "]";
	}
	
}
