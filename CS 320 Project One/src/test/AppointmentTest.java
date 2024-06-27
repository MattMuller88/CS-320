package test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.model.Appointment;

class AppointmentTest {

	@Test
	void appointmentTest() {
		Date testDate = new Date();
		Date futureDate = new Date(testDate.getTime() + 10);
		Appointment appointment = new Appointment("123456789", futureDate, "Appointment description");
		assertTrue(appointment.getAppointmentID() == "123456789");
		assertTrue(appointment.getDate() == futureDate);
		assertTrue(appointment.getDescription() == "Appointment description");
	}
	
	@Test
	void appointmentIDTooLong() {
		Date testDate = new Date();
		assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("12345678910", testDate, "Appointment description");
		});
	}

	@Test
	void appointmentIDIsNull() {
		Date testDate = new Date();
		assertThrows(IllegalArgumentException.class, () ->{
			new Appointment(null, testDate, "Appointment description");
		});
	}
	
	@Test
	void dateInPast() {
		Date currentDate = new Date(System.currentTimeMillis());
		Date pastDate = new Date(currentDate.getTime() - 10);
		assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("123456789", pastDate, "Appointment description");
		});
	}
	
	@Test
	void dateIsNull() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("123456789", null, "Appointment description");
		});
	}

	@Test
	void descriptionTooLong() {
		Date testDate = new Date();
		assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("123456789", testDate, "Really long appointment description that is more than 50 characters.");
		});
	}
	
	@Test
	void descriptionIsNull() {
		Date testDate = new Date();
		assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("123456789", testDate, null);
		});
	}
}
