package main.java.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppointmentService {
//Declare list to hold Appointments
	private ArrayList<Appointment> appointmentList;
		
//Default constructor
	public AppointmentService() {
		appointmentList = new ArrayList<Appointment>();
	}
		
//Appointment list getter
	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}
		
//Method to create appointment with unique ID and add it to appointment list
	public void addAppointment(String appointmentID, Date date, String description) {
		boolean unique = true;
		for (int i = 0; i < appointmentList.size(); i++) {
			if (appointmentID == appointmentList.get(i).getAppointmentID()) {
				unique = false;
			}
		}
		if (unique == true) {
			Appointment appointment = new Appointment(appointmentID, date, description);
			appointmentList.add(appointment);
		}
		else {
			throw new IllegalArgumentException("Duplicate appointment ID");
		}
	}
		
//Method to delete appointment with provided ID
	public void deleteAppointment(String id) {
		for (int i = 0; i < appointmentList.size(); i++) {
			if (id == appointmentList.get(i).getAppointmentID()) {
				appointmentList.remove(i);
			}
		}
	}
}
