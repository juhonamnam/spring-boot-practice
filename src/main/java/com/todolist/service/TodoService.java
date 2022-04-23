package com.todolist.service;

import java.util.List;

import com.todolist.entity.Todo;

public interface TodoService {

	public List<Todo> retrieveTodo();

	public Todo createTodo(Todo post) throws Exception;

	public Todo deleteTodo(int id) throws Exception;

}
