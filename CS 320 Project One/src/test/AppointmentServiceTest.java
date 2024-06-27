package test;

import java.util.Date;
import java.util.List;

import main.java.model.AppointmentService;
import main.java.model.Appointment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppointmentServiceTest {

	@Test
	void addAppointmentTest() {
		AppointmentService service = new AppointmentService();
		Date testDate = new Date();
		Date futureDate = new Date(testDate.getTime() + 10);
		service.addAppointment("123456789", futureDate, "Appointment Description");
		List<Appointment> list = service.getAppointmentList();
		boolean test = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAppointmentID() == "123456789") {
				test = true;
			}
		}
		assertTrue(test);
	}
	
	@Test
	void addDuplicateTest() {
		Date testDate = new Date();
		Date futureDate = new Date(testDate.getTime() + 10);
		AppointmentService service = new AppointmentService();
		service.addAppointment("123456789", futureDate, "Appointment Description");
		assertThrows(IllegalArgumentException.class, () ->{
			service.addAppointment("123456789", futureDate, "Appointment Description");
		});
	}

	@Test
	void deleteAppointmentTest() {
		Date testDate = new Date();
		Date futureDate = new Date(testDate.getTime() + 10);
		AppointmentService service = new AppointmentService();
		service.addAppointment("123456789", futureDate, "Appointment Description");
		boolean test = false;
		for (int i = 0; i < service.getAppointmentList().size(); i++) {
			if (service.getAppointmentList().get(i).getAppointmentID() == "123456789") {
				test = true;
			}
		}
		assertTrue(test);
		service.deleteAppointment("123456789");
		test = false;
		for (int i = 0; i < service.getAppointmentList().size(); i++) {
			if (service.getAppointmentList().get(i).getAppointmentID() == "123456789") {
				test = true;
			}
		}
		assertFalse(test);
	}
	

}
