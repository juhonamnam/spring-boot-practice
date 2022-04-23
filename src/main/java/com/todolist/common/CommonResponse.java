package com.todolist.common;

public interface CommonResponse<T> {

	public void setData(T data);

	public void setMessage(String message);

}
