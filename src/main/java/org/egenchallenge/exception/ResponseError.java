package org.egenchallenge.exception;

public class ResponseError {

	private String errorMessage;
	
	public ResponseError(String message){
		this.errorMessage = message;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
