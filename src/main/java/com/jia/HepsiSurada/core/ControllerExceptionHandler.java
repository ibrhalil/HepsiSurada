package com.jia.HepsiSurada.core;

import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class ControllerExceptionHandler 
{
	/*
	@ResponseBody
    @ResponseStatus(value = HttpStatus.PRECONDITION_FAILED)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Result> constraintViolationException(MethodArgumentNotValidException e) 
	{
        DefaultExceptionMessage dex = new DefaultExceptionMessage();
        dex.setCode(HttpStatus.PRECONDITION_FAILED.value());
        dex.setMessage(e.getFieldErrors().get(0).getDefaultMessage());
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(dex);
    }
    */
}
