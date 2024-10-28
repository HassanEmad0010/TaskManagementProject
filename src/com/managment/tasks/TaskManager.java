package com.managment.tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskManager implements TaskManagerInterface{
private final String tasksFilePath = "Saved Tasks.txt";

	List<Task> tasks;



	public TaskManager() {
		tasks = new ArrayList<Task>();
	}



	@Override
	public boolean addTask(Task task) {

		try {
			if (!(tasks.contains(task)))
			{
				tasks.add(task);
				return true;				
			}

		} catch (Exception e) {
			return false;
		}
		return false;
	}



	@Override
	public boolean completeTask(Task task) {

		if ((tasks.contains(task)))
		{
		try {
			task.setStatus(TaskStatus.COMPLETED);
			return true;
			
		} catch (Exception e) {
			return false;
		}

		}
		 
			return false;
	}
	
	@Override
	public boolean completeTask(String title) {

		
		Task task = returnTaskByTitle(title);
		
		if ((tasks.contains(task)))
		{
		try {
			task.setStatus(TaskStatus.COMPLETED);
			return true;
			
		} catch (Exception e) {
			return false;
		}

		}
		 
			return false;
	}

	
	public Task returnTaskByTitle (String title)
	{
		for (Task task : tasks)
		{
			if (task.getTitle().equals(title))
			{
				return task;
			}
		}
		return null;
	}

	@Override
	public Task editTaskDescription(Task task, String newDescription) {

		if ((tasks.contains(task)))
		{
			try {
				 task.setDescription(newDescription);
				return task;
				
			} catch (Exception e) {
				// TODO: handle exception
			}	
		}
		return null;
		
	
	}
				
	

	@Override
	public List<Task> viewTasks() {
		return tasks;
	}



	@Override
	public boolean saveTasks() {

		try {
			BufferedWriter bWriter = new BufferedWriter(new FileWriter(tasksFilePath,true) );
			int i = 0;
			for (Task task : tasks )
			{
				bWriter.write(task.getTitle()+","+task.getDescription()+","+ task.getDueDate()+","+task.getStatus()+","+task.getPriority());
				bWriter.newLine();
			i++;	
			}
			bWriter.flush();
			bWriter.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}



	@Override
	public boolean loadTasks() {

		try {
			BufferedReader bReader = new BufferedReader(new FileReader(tasksFilePath));
			try {
				
				tasks.clear();
				
				String line ;
				
				while ( (line = bReader.readLine()) != null )
				{
				System.out.println(line);
				String [] parts =line.split("," , -1);
				String title = parts[0];
				String desc = parts[1];
				String locDateString = parts[2];
				LocalDate localDate = LocalDate.parse(locDateString);
				String statusString = parts[3];
				TaskStatus taskStatus = TaskStatus.valueOf(statusString);
				String perirityString = parts[4];
				Priority priority =  Priority.valueOf(perirityString);

				Task task = new Task(title, desc, localDate, taskStatus, priority);
				
				System.out.println(task.toString());
				
				tasks.add(task);
				
				
				}
				
				
				
				bReader.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		
		return false;
	}



}
