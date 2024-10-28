package com.managment.tasks;

import java.util.List;

public interface TaskManagerInterface {

	
	public boolean addTask(Task task);	
//	public Task getTask ();
	public boolean completeTask(Task task);
	public Task editTaskDescription(Task task, String description);
	public List<Task> viewTasks();
	public boolean saveTasks();
	public boolean loadTasks();


	
	
	
}
