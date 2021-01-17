package com.nolesiak.bookstoreapp.controllers;

import com.nolesiak.bookstoreapp.api.mapper.EmployeeMapper;
import com.nolesiak.bookstoreapp.services.EmployeeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee/")
public class EmployeeController {

    private final EmployeeService employeeService;
    private EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }


}
