package com.java.mongosql.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@ControllerAdvice
public class ProductExceptionHandler {

    private Logger logger= Logger.getLogger(ProductExceptionHandler.class.getName());

    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> runtimeExc(RuntimeException e){

        ProductErrorResponse response=new ProductErrorResponse(HttpStatus.NOT_FOUND.value(),e.getMessage(), LocalDateTime.now());
        logger.info(response.toString());

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> allExc(Exception exception){
        ProductErrorResponse response=new ProductErrorResponse(HttpStatus.BAD_REQUEST.value(),exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
