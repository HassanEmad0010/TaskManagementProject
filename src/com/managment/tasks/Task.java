package com.managment.tasks;

import java.time.LocalDate;

public class Task {

	
	private String title;
	public String description;
	private LocalDate dueDate;
	private TaskStatus status;
	private Priority priority;
	private static int MAX_TASKS_NUMBER= 5;
	
	
	
	
	public Task(String title, String description, LocalDate dueDate, TaskStatus status, Priority priority) {
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.status = status;
		this.priority = priority;
	}
	
	
	public String getTitle() {
		return this.title;
	}
	private void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	private void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public TaskStatus getStatus() {
		return status;
	}
	public void setStatus(TaskStatus taskStatus) {
		this.status = taskStatus;
	}
	public Priority getPriority() {
		return priority;
	}
	private void setPriority(Priority priority) {
		this.priority = priority;
	}


	
	public static int getMAX_TASKS_NUMBER() {
		return MAX_TASKS_NUMBER;
	}


	public static void setMAX_TASKS_NUMBER(int mAX_TASKS_NUMBER) {
		MAX_TASKS_NUMBER = mAX_TASKS_NUMBER;
	}


	@Override
	public String toString() {
		return "Task [title=" + title + ", description=" + description + ", dueDate=" + dueDate + ", status=" + status
				+ ", priority=" + priority + "]";
	}
	
	
	
	
	
}
