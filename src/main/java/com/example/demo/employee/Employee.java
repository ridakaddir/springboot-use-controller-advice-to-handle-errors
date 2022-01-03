package com.example.demo.employee;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
class Employee {
    Long id;
    String name;
    Double salary;
}
