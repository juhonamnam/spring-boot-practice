package com.todolist.service;

import java.util.List;

import com.todolist.entity.TodoItem;

public interface TodoService {

	public List<TodoItem> retrieveTodoList();

	public TodoItem retrieveTodoItem(int id) throws Exception;

	public TodoItem createTodoItem(TodoItem todoItem) throws Exception;

	public TodoItem deleteTodoItem(int id) throws Exception;

}
