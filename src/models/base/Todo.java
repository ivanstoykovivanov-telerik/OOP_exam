package models.base;

import models.TodoState;

public class Todo extends Item  {
	private TodoState state;

	public Todo(String title, String description, TodoState state) {
		super(title, description);
		this.state = state;
	}

	public TodoState getState() {
		return state;
	}

	public void setState(TodoState state) {
		this.state = state;
	}
}
