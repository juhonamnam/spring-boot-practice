package com.todolist.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.todolist.entity.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

}
