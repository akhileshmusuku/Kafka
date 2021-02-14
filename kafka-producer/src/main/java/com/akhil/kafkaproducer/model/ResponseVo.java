package com.akhil.kafkaproducer.model;

public class ResponseVo {
	
	private String message;
	private String status;
	

	
	public ResponseVo(String message, String status) {
		super();
		this.message = message;
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Response [message=" + message + ", status=" + status + "]";
	}

}
