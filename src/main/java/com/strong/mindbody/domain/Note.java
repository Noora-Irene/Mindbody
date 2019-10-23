package com.strong.mindbody.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Note {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String day;
	private double date;
	
	@ManyToOne
    @JoinColumn(name = "workoutId")
    private Workout workout;
	
	@ManyToOne
    @JoinColumn(name = "powerId")
    private Power power;
	
	private int time, kcal;
	
	public Note() {}

	public Note(String day, double date, Workout workout, Power power, int time, int kcal) {
		super();
		this.day = day;
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

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
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
		return "Note [day=" + day + ", date=" + date + ", workout=" + workout +" , power=" + power +" time=" + time + ", kcal=" + kcal + "]";
	}
	
}
