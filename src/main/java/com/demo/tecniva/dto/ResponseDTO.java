package com.demo.tecniva.dto;

public class ResponseDTO<T> {
	private T object;
	private String message;
	
	public ResponseDTO() {
		
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseDTO [object=" + object + ", message=" + message + "]";
	}
}
