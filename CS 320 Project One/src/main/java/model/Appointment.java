package main.java.model;

import java.util.Date;

public class Appointment {
//Attributes
	private String appointmentID;
	private Date date;
	private String description;
	
	
//Create appointment with given information
	public Appointment(String appointmentID, Date date, String description) {
		if(appointmentID == null || appointmentID.length() > 10) {
			throw new IllegalArgumentException("Invalid appointment ID");
		}		
			this.appointmentID = appointmentID;
			this.setDate(date);
			this.setDescription(description);
	}


//Getters
	public String getAppointmentID() {
		return appointmentID;
	}


	public Date getDate() {
		return date;
	}
	
	public String getDescription() {
		return description;
	}

	
//Setters
	public void setDate(Date date) {
		if (date == null || date.before(new Date())) {
			throw new IllegalArgumentException("Invalid date");
		}
		this.date = date;
	}

	public void setDescription(String description) {
		if(description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		this.description = description;
	}

}
