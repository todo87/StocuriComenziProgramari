package ro.stefan.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsController {

    @ExceptionHandler(Exception.class)
    public void exception(Exception e){
        e.printStackTrace();
    }

}
