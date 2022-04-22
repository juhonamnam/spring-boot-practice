package com.todolist.service;

import java.util.List;

import com.todolist.entity.Todo;

public interface TodoService {

	public List<Todo> retrievePost();

	public Todo createPost(Todo post);

	public Todo modifyPost(int id, Todo post) throws Exception;

	public Todo deletePost(int id) throws Exception;

}
