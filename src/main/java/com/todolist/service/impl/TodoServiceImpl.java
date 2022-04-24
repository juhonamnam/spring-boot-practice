package com.todolist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.entity.TodoItem;
import com.todolist.repository.TodoRepository;
import com.todolist.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository todoRepository;

	@Override
	public List<TodoItem> retrieveTodoList() {
		return (List<TodoItem>) todoRepository.findAll();
	}

	@Override
	public TodoItem createTodoItem(TodoItem todoItem) throws Exception {
		if (todoItem.getContent().isEmpty())
			throw new Exception("Cannot Create Empty Item");
		long count = todoRepository.count();
		if (count >= 10) {
			throw new Exception("Cannot Create More Than 10");
		}
		return todoRepository.save(todoItem);
	}

	@Override
	public TodoItem deleteTodoItem(int id) throws Exception {
		TodoItem deletableTodoItem = todoRepository.findById(id).orElse(null);
		if (deletableTodoItem == null)
			throw new Exception("Invalid Id");
		todoRepository.deleteById(id);
		return deletableTodoItem;
	}

}
