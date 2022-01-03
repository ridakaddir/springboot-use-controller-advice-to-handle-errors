package com.example.demo.employee;

import org.springframework.http.HttpStatus;

public class EmployeeNotFoundException extends RuntimeException {
    private HttpStatus status;

    public EmployeeNotFoundException() {
        super("employee not found");
        this.status = HttpStatus.NOT_FOUND;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "EmployeeNotFoundException{" +
                "status=" + status +
                " , message=" + this.getMessage() +
                '}';
    }
}
