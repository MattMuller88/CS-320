package main.java.model;

import java.util.ArrayList;
import java.util.List;


public class TaskService {
//Declare list to hold tasks
	private ArrayList<Task> taskList;
	
//Default constructor
	public TaskService() {
		taskList = new ArrayList<Task>();
	}
	
//Task list getter
	public List<Task> getTaskList() {
		return taskList;
	}
	
//Method to create task with unique ID and add it to task list
	public void addTask(String id) {
		boolean unique = true;
		for (int i = 0; i < taskList.size(); i++) {
			if (id == taskList.get(i).getID()) {
				unique = false;
			}
		}
		if (unique == true) {
			Task task = new Task(id);
			taskList.add(task);
		}
		else {
			System.out.println("Task ID already exists.");
		}
	}
	
//Method to delete task with provided ID
	public void deleteTask(String id) {
		for (int i = 0; i < taskList.size(); i++) {
			if (id == taskList.get(i).getID()) {
				taskList.remove(i);
			}
		}
	}
	
//Method for updating task fields per task ID
	public void updateTask(String id, String newName, String newDescription) {
		boolean search = false;
		for (int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getID() == id) {
				search = true;
				taskList.get(i).setName(newName);
				taskList.get(i).setDescription(newDescription);
			}
		}
		if(search == false) {
			System.out.println("No Task exists with given ID.");
		}
	}
}
