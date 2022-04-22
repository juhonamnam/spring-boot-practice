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
	private TodoRepository postRepository;

	@Override
	public List<Todo> retrievePost() {
		return (List<Todo>) postRepository.findAll();
	}

	@Override
	public Todo createPost(Todo post) {
		return postRepository.save(post);
	}

	@Override
	public Todo modifyPost(int id, Todo post) throws Exception {
		Todo originalPost = postRepository.findById(id).orElse(null);
		if (originalPost == null)
			throw new Exception("Post Doesn't Exist");
		post.setId(id);
		return postRepository.save(post);
	}

	@Override
	public Todo deletePost(int id) throws Exception {
		Todo deletablePost = postRepository.findById(id).orElse(null);
		if (deletablePost == null)
			throw new Exception("Post Doesn't Exist");
		postRepository.deleteById(id);
		return deletablePost;
	}

}
