package com.todolist.common;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CommonResponseFail<T> implements CommonResponse<T> {

	private final boolean ok = false;

	private String message;

	@Override
	public void setData(T data) {
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}

}
