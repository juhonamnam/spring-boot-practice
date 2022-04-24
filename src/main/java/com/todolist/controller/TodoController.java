package com.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.common.CommonResponse;
import com.todolist.common.CommonResponseFail;
import com.todolist.common.CommonResponseSuccess;
import com.todolist.entity.TodoItem;
import com.todolist.service.TodoService;

@RestController
@RequestMapping("/api/todo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping("/retrieveTodoList")
	public ResponseEntity<CommonResponse<List<TodoItem>>> retrieveTodoList() {
		CommonResponse<List<TodoItem>> response;
		try {
			List<TodoItem> todoList = todoService.retrieveTodoList();
			response = new CommonResponseSuccess<List<TodoItem>>();
			response.setData(todoList);
		} catch (Exception e) {
			response = new CommonResponseFail<List<TodoItem>>();
			response.setMessage(e.getMessage());
		}
		return new ResponseEntity<CommonResponse<List<TodoItem>>>(response, HttpStatus.OK);
	}

	@PostMapping("/createTodoItem")
	public ResponseEntity<CommonResponse<TodoItem>> createTodoItem(@RequestBody TodoItem todoItem) {
		CommonResponse<TodoItem> response;
		try {
			TodoItem createdTodoItem = todoService.createTodoItem(todoItem);
			response = new CommonResponseSuccess<TodoItem>();
			response.setData(createdTodoItem);
		} catch (Exception e) {
			response = new CommonResponseFail<TodoItem>();
			response.setMessage(e.getMessage());
		}
		return new ResponseEntity<CommonResponse<TodoItem>>(response, HttpStatus.OK);
	}

	@DeleteMapping("/deleteTodoItem/{id}")
	public ResponseEntity<CommonResponse<TodoItem>> deleteTodoItem(@PathVariable("id") int id) {
		CommonResponse<TodoItem> response;
		try {
			TodoItem deletedTodoItem = todoService.deleteTodoItem(id);
			response = new CommonResponseSuccess<TodoItem>();
			response.setData(deletedTodoItem);
		} catch (Exception e) {
			response = new CommonResponseFail<TodoItem>();
			response.setMessage(e.getMessage());
		}
		return new ResponseEntity<CommonResponse<TodoItem>>(response, HttpStatus.OK);
	}

}
