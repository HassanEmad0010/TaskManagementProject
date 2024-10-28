package com.managment.tasks;

import java.time.LocalDate;

public class MainClass {

	public static void main(String [] argus)
	{
		
		System.out.println("Welcome to Task manager");
		TaskManager taskManager = new TaskManager();

		taskManager.loadTasks();

		
		LocalDate localDate = LocalDate.now() ;
		Task task1 = new Task("title1", "the 3 task",localDate , TaskStatus.pending, Priority.high);
		taskManager.addTask(task1);		
		Task task2 = new Task("title5", "the 54 task",localDate , TaskStatus.pending, Priority.low);
		taskManager.addTask(task2);
		
		
		
		System.out.println("Tasks: "+ taskManager.viewTasks().toString());
		
		taskManager.completeTask(task1);
		taskManager.editTaskDescription(task1, "new Desc for task 1");
		System.out.println("Tasks: "+ taskManager.viewTasks().toString());

		System.out.println("Saving tasks status...."+ taskManager.saveTasks() );
	
		
		for (Task task : taskManager.viewTasks())
		{
		System.out.println("All tasks Titles:" +task.getTitle());
		}
	}
	
}
