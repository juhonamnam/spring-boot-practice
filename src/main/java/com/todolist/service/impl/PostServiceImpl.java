package com.todolist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.entity.Post;
import com.todolist.repository.PostRepository;
import com.todolist.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Override
	public List<Post> retrievePost() {
		return (List<Post>) postRepository.findAll();
	}

	@Override
	public Post createPost(Post post) {
		return postRepository.save(post);
	}

	@Override
	public Post modifyPost(int id, Post post) throws Exception {
		Post originalPost = postRepository.findById(id).orElse(null);
		if (originalPost == null)
			throw new Exception("Post Doesn't Exist");
		post.setId(id);
		return postRepository.save(post);
	}

	@Override
	public Post deletePost(int id) throws Exception {
		Post deletablePost = postRepository.findById(id).orElse(null);
		if (deletablePost == null)
			throw new Exception("Post Doesn't Exist");
		postRepository.deleteById(id);
		return deletablePost;
	}

}
