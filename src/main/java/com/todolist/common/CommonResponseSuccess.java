package com.todolist.common;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CommonResponseSuccess<T> implements CommonResponse<T> {

	private boolean ok;

	private T data;

	@Override
	public void setOk(boolean ok) {
		this.ok = ok;
	}

	@Override
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public void setMessage(String message) {
	}

}
