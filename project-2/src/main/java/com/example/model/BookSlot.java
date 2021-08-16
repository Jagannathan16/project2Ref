package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "book_slot")
public class BookSlot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String sport;
	
	@Temporal(TemporalType.DATE)
	Date date;
	
	String time;
	
	@Column(name = "paid")
	boolean booked;
	
	
	public BookSlot() {
		super();
	}


	public BookSlot(int id, String name,String sport, Date date, String time, boolean booked) {
		super();
		this.id = id;
		this.name = name;
		this.sport = sport;
		this.date = date;
		this.time = time;
		this.booked = booked;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
	
	public String getSport() {
		return sport;
	}


	public void setSport(String sport) {
		this.sport = sport;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public boolean isBooked() {
		return booked;
	}


	public void setBooked(boolean booked) {
		this.booked = booked;
	}
	
	
}
