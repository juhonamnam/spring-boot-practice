package com.todolist.service;

import java.util.List;

import com.todolist.entity.Post;

public interface PostService {

	public List<Post> retrievePost();

	public Post createPost(Post post);

	public Post modifyPost(int id, Post post) throws Exception;

	public Post deletePost(int id) throws Exception;

}
