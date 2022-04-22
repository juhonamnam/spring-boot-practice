package com.todolist.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.todolist.entity.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Integer> {

}