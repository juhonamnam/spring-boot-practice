package com.todolist.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "todo")
public class Todo {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue
	private int id;

	@Column(name = "content", length = 100)
	private String content;

	@Column(name = "created")
	@CreationTimestamp
	private Timestamp created;
}
