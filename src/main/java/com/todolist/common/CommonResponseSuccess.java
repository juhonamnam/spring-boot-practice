package com.todolist.common;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CommonResponseSuccess<T> implements CommonResponse<T> {

	private final boolean ok = true;

	private T data;

	@Override
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public void setMessage(String message) {
	}

}
