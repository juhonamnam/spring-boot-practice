package com.todolist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.entity.Todo;
import com.todolist.repository.TodoRepository;
import com.todolist.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository todoRepository;

	@Override
	public List<Todo> retrieveTodo() {
		return (List<Todo>) todoRepository.findAll();
	}

	@Override
	public Todo createTodo(Todo todo) {
		return todoRepository.save(todo);
	}

	@Override
	public Todo modifyTodo(int id, Todo todo) throws Exception {
		Todo originalTodo = todoRepository.findById(id).orElse(null);
		if (originalTodo == null)
			throw new Exception("Invalid Todo Id");
		todo.setId(id);
		return todoRepository.save(todo);
	}

	@Override
	public Todo deleteTodo(int id) throws Exception {
		Todo deletableTodo = todoRepository.findById(id).orElse(null);
		if (deletableTodo == null)
			throw new Exception("Invalid Todo Id");
		todoRepository.deleteById(id);
		return deletableTodo;
	}

}
