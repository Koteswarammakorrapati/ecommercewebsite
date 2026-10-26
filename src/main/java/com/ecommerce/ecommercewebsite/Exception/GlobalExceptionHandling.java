package com.ecommerce.ecommercewebsite.Exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {
    @ExceptionHandler(UserAlreadyExsistException.class)
    public ResponseEntity<Map<String,Object>> userAlreayExsistsException(UserAlreadyExsistException u){
    	Map<String,Object>error =new HashMap<String, Object>();
		error.put("message", u.getMessage());
		error.put("time", LocalDateTime.now());
		error.put("date", LocalDate.now());
		error.put("status", "400 Bad Request");
		
		ResponseEntity<Map<String, Object>> response=new ResponseEntity<Map<String,Object>>(error, HttpStatus.BAD_REQUEST);
		return response;
    }
	
}
