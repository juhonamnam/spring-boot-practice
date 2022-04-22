package com.todolist.common;

public interface CommonResponse<T> {

	public void setOk(boolean ok);

	public void setData(T data);

	public void setMessage(String message);

}
