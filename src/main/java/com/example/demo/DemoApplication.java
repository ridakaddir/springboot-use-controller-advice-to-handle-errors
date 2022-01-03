package com.example.demo;

import com.example.demo.employee.EmployeeNotFoundException;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

@Slf4j
@ControllerAdvice
class RestExceptionHandler{

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<ErrorBody> handleException(EmployeeNotFoundException exception){
        log.error(exception.toString());
        return new ResponseEntity<>(ErrorBody.builder()
                .error(exception.getStatus().name())
                .status(exception.getStatus().value())
                .message(exception.getMessage())
                .build(), exception.getStatus());
    }

}

@Getter
@Builder
class ErrorBody{
    private String error;
    private int status;
    private String message;
}

