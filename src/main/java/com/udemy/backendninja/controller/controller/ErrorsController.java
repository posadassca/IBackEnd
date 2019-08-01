package com.udemy.backendninja.controller.controller;

import com.udemy.backendninja.controller.Constante;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorsController {

    @ExceptionHandler(Exception.class)
    public String showInternalServerError(){
        return Constante.INTERNAL_SERVER_ERROR_VIEW;
    }
}
