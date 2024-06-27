package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.model.Task;

class TaskTest {

	@Test
	void testTask() {
		Task task = new Task("12345");
		assertTrue(task.getID().equals("12345"));
	}

	@Test
	void taskIDTooLongTest() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Task("12345678910");
		});
	}
	
	@Test
	void nameTooLongTest() {
		assertThrows(IllegalArgumentException.class, () ->{
			Task task = new Task("12345");
			task.setName("This name is longer than 20 characters");
		});
	}
	
	@Test
	void descriptionTooLongTest() {
		assertThrows(IllegalArgumentException.class, () ->{
			Task task = new Task("12345");
			task.setDescription("This is a very long Task description that goes beyond the alloted 50 character limit.");
		});
	}
	
	@Test
	void taskIDisnullTest() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Task(null);
		});
	}
	
	@Test
	void nameIsnullTest() {
		assertThrows(IllegalArgumentException.class, () ->{
			Task task = new Task("12345");
			task.setName(null);
		});
	}
	
	@Test
	void descriptionIsnullTest() {
		assertThrows(IllegalArgumentException.class, () ->{
			Task task = new Task("12345");
			task.setDescription(null);
		});
	}
}
