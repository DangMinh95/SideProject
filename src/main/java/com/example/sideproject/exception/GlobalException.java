package com.example.sideproject.exception;

import com.example.sideproject.response.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(BindException.class)
    public ResponseError handleEmptyValue(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();
        assert fieldError != null : "No field error";
        String messageFormatted = String.format("Column %s %s", fieldError.getField(), fieldError.getDefaultMessage());

        return new ResponseError(HttpStatus.BAD_REQUEST.value(), messageFormatted);
    }

    @ExceptionHandler(Exception.class)
    public ResponseError handleException(Exception e) {
        return new ResponseError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }
}
