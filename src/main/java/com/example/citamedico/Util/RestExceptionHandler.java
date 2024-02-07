package com.example.citamedico.Util;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<ErrorDetail> handlerResourcesNotFoundException(ResourcesNotFoundException e, HttpServletRequest request){
        ErrorDetail errorDetail = new ErrorDetail();

        errorDetail.setTimeStamp(new Date().getTime());
        errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
        errorDetail.setMessage(e.getMessage());
        errorDetail.setDetails("Error");

        return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
    }

}
