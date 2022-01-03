package com.example.demo.employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
class EmployeeResource {

    List<Employee> employees = new ArrayList<>(
            List.of(
                    Employee.builder().id(1l).name("employee1").salary(100000d).build(),
                    Employee.builder().id(2l).name("employee2").salary(120000d).build()
            )
    );

    @GetMapping
    List<Employee> getEmployees() {
        return employees;
    }

    @GetMapping("/{id}")
    Employee getByID(@PathVariable Long id) {
        return employees.stream()
                .filter(e -> e.id == id)
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);
    }


}
