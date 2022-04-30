package com.todolist.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.todolist.entity.TodoItem;

@Repository
public interface TodoRepository extends CrudRepository<TodoItem, Integer> {

	@Query("SELECT COUNT(t) FROM TodoItem t")
	long count();

}
