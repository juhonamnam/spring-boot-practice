package com.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.todolist.entity.Post;
import com.todolist.service.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping("/retrievePost")
	public ResponseEntity<CommonResponse<List<Post>>> retrievePost() {
		CommonResponse<List<Post>> response;
		try {
			List<Post> posts = postService.retrievePost();
			response = new CommonResponseSuccess<List<Post>>();
			response.setOk(true);
			response.setData(posts);
		} catch (Exception e) {
			response = new CommonResponseFail<List<Post>>();
			response.setOk(false);
			response.setMessage(e.getMessage());
		}
		return new ResponseEntity<CommonResponse<List<Post>>>(response, HttpStatus.OK);
	}

	@PostMapping("/createPost")
	public ResponseEntity<CommonResponse<Post>> createPost(@RequestBody Post post) {
		CommonResponse<Post> response;
		try {
			Post addedPost = postService.createPost(post);
			response = new CommonResponseSuccess<Post>();
			response.setOk(true);
			response.setData(addedPost);
		} catch (Exception e) {
			response = new CommonResponseFail<Post>();
			response.setOk(false);
			response.setMessage(e.getMessage());
		}
		return new ResponseEntity<CommonResponse<Post>>(response, HttpStatus.OK);
	}

	@PutMapping("/modifyPost/{id}")
	public ResponseEntity<CommonResponse<Post>> modifyPost(@PathVariable("id") int id, @RequestBody Post post) {
		CommonResponse<Post> response;
		try {
			Post modifiedPost = postService.modifyPost(id, post);
			response = new CommonResponseSuccess<Post>();
			response.setOk(true);
			response.setData(modifiedPost);
		} catch (Exception e) {
			response = new CommonResponseFail<Post>();
			response.setOk(false);
			response.setMessage(e.getMessage());
		}
		return new ResponseEntity<CommonResponse<Post>>(response, HttpStatus.OK);
	}

	@DeleteMapping("/deletePost/{id}")
	public ResponseEntity<CommonResponse<Post>> deletePost(@PathVariable("id") int id) {
		CommonResponse<Post> response;
		try {
			Post deletedPost = postService.deletePost(id);
			response = new CommonResponseSuccess<Post>();
			response.setOk(true);
			response.setData(deletedPost);
		} catch (Exception e) {
			response = new CommonResponseFail<Post>();
			response.setOk(false);
			response.setMessage(e.getMessage());
		}
		return new ResponseEntity<CommonResponse<Post>>(response, HttpStatus.OK);
	}

}
