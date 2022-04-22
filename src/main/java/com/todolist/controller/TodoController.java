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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.common.CommonResponse;
import com.todolist.common.CommonResponseFail;
import com.todolist.common.CommonResponseSuccess;
import com.todolist.entity.Todo;
import com.todolist.service.TodoService;

@RestController
@RequestMapping("/api/todo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TodoController {

	@Autowired
	private TodoService postService;

	@GetMapping("/retrievePost")
	public ResponseEntity<CommonResponse<List<Todo>>> retrievePost() {
		CommonResponse<List<Todo>> response;
		try {
			List<Todo> posts = postService.retrievePost();
			response = new CommonResponseSuccess<List<Todo>>();
			response.setOk(true);
			response.setData(posts);
		} catch (Exception e) {
			response = new CommonResponseFail<List<Todo>>();
			response.setOk(false);
			response.setMessage(e.getMessage());
		}
		return new ResponseEntity<CommonResponse<List<Todo>>>(response, HttpStatus.OK);
	}

	@PostMapping("/createPost")
	public ResponseEntity<CommonResponse<Todo>> createPost(@RequestBody Todo post) {
		CommonResponse<Todo> response;
		try {
			Todo addedPost = postService.createPost(post);
			response = new CommonResponseSuccess<Todo>();
			response.setOk(true);
			response.setData(addedPost);
		} catch (Exception e) {
			response = new CommonResponseFail<Todo>();
			response.setOk(false);
			response.setMessage(e.getMessage());
		}
		return new ResponseEntity<CommonResponse<Todo>>(response, HttpStatus.OK);
	}

	@PutMapping("/modifyPost/{id}")
	public ResponseEntity<CommonResponse<Todo>> modifyPost(@PathVariable("id") int id, @RequestBody Todo post) {
		CommonResponse<Todo> response;
		try {
			Todo modifiedPost = postService.modifyPost(id, post);
			response = new CommonResponseSuccess<Todo>();
			response.setOk(true);
			response.setData(modifiedPost);
		} catch (Exception e) {
			response = new CommonResponseFail<Todo>();
			response.setOk(false);
			response.setMessage(e.getMessage());
		}
		return new ResponseEntity<CommonResponse<Todo>>(response, HttpStatus.OK);
	}

	@DeleteMapping("/deletePost/{id}")
	public ResponseEntity<CommonResponse<Todo>> deletePost(@PathVariable("id") int id) {
		CommonResponse<Todo> response;
		try {
			Todo deletedPost = postService.deletePost(id);
			response = new CommonResponseSuccess<Todo>();
			response.setOk(true);
			response.setData(deletedPost);
		} catch (Exception e) {
			response = new CommonResponseFail<Todo>();
			response.setOk(false);
			response.setMessage(e.getMessage());
		}
		return new ResponseEntity<CommonResponse<Todo>>(response, HttpStatus.OK);
	}

}
