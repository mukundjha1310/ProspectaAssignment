package com.mukund.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobelExceptionHandler {
	
	@ExceptionHandler(EntryException.class)
	public ResponseEntity<MyErrorDetails> customException(EntryException ee, WebRequest wReq)
	{
		MyErrorDetails error = new MyErrorDetails();
		
		error.setTimeStamp(LocalDateTime.now());
		error.setMessage(ee.getMessage());
		error.setDiscription(wReq.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}

}
