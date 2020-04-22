package com.model;

public class FailureResponse {

	private String status;
	private String message;
	private String error_type;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError_type() {
		return error_type;
	}

	public void setError_type(String error_type) {
		this.error_type = error_type;
	}

	public FailureResponse() {
	}

	public FailureResponse(String status, String message, String error_type) {
		this.status = status;
		this.message = message;
		this.error_type = error_type;
	}
	
	@Override
	public String toString() {
		return "FailureResponse [status=" + status + ", message=" + message + ", error_type=" + error_type + "]";
	}

}
