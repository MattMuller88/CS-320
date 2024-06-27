package main.java.model;

public class Task {
//Attributes
	private String taskID;
	private String name;
	private String description;
	
//Create task with given ID
	public Task(String id) {
	//Validate provided ID
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid task ID");
		}
	//Set taskID
		this.taskID = id;
	}

//Getters
	public String getID() {
		return taskID;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
//Setters
	public void setName(String name) {
		if(name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid task name");
		}
		this.name = name;
	}

	public void setDescription(String description) {
		if(description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid task description");
		}
		this.description = description;
	}

}
