package com.todolist.common;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CommonResponseFail<T> implements CommonResponse<T> {

	private boolean ok;

	private String message;

	@Override
	public void setOk(boolean ok) {
		this.ok = ok;
	}

	@Override
	public void setData(T data) {
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}

}
