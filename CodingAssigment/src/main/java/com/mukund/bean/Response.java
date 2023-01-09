package com.mukund.bean;

import java.time.LocalDateTime;
import java.util.Map;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@JsonInclude(Include.NON_NULL)
public class Response {
	
	private LocalDateTime timeStamp;
	private Integer statusCode;
	private HttpStatus httpStatus;
	private String message;
	private Map<?, ?> data;
	
}
