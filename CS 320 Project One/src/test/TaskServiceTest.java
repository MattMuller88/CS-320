package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.model.Task;
import main.java.model.TaskService;

class TaskServiceTest {

	@Test
	void addTaskTest() {
		TaskService service = new TaskService();
		service.addTask("TaskID");
		List<Task> list = service.getTaskList();
		boolean test = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getID() == "TaskID") {
				test = true;
			}
		}
		assertTrue(test);
	}
	
	@Test
	void deleteTaskTest() {
		TaskService service = new TaskService();
		service.addTask("TaskID");
		boolean test = false;
		for (int i = 0; i < service.getTaskList().size(); i++) {
			if (service.getTaskList().get(i).getID() == "TaskID") {
				test = true;
			}
		}
		assertTrue(test);
		service.deleteTask("TaskID");
		test = false;
		for (int i = 0; i < service.getTaskList().size(); i++) {
			if (service.getTaskList().get(i).getID() == "TaskID") {
				test = true;
			}
		}
		assertFalse(test);
	}
	
	@Test
	void updateTaskTest() {
		TaskService service = new TaskService();
		service.addTask("TaskID");
		service.updateTask("TaskID", "New Name", "New Description");
		boolean test = false;
		for (int i = 0; i < service.getTaskList().size(); i++) {
			if (service.getTaskList().get(i).getID() == "TaskID") {
				if(service.getTaskList().get(i).getName() == "New Name" && service.getTaskList().get(i).getDescription() == "New Description") {
					test = true;
			}
		}
		}
		assertTrue(test);
	}

}
