package com.kodluyoruz.eticaret.Exceptions;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sevgidemir
 */

@RestControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    Map<String,String> handleExceptionn(MethodArgumentNotValidException exception){
        Map<String,String> apiError=new HashMap<>();


        if (exception.getFieldErrorCount()>0){
            for (FieldError fieldError: exception.getBindingResult().getFieldErrors()){
                apiError.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            if (exception.getGlobalErrorCount()>0){
                for (ObjectError objectError: exception.getBindingResult().getGlobalErrors()){
                    apiError.put(objectError.getObjectName(),objectError.getDefaultMessage());
                }
            }
        }
        return apiError;
    }

}
