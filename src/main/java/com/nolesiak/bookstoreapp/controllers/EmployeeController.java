package com.nolesiak.bookstoreapp.controllers;


import com.nolesiak.bookstoreapp.api.model.EmployeeDTO;
import com.nolesiak.bookstoreapp.api.model.LibraryDTO;
import com.nolesiak.bookstoreapp.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee/")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("getAllEmployees")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("getEmployeeById/{employeeID}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeID){
        return  employeeService.getEmployeeById(employeeID);
    }
    @DeleteMapping("deleteEmployee/{employeeID}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployeeById(@PathVariable Long employeeID){
        employeeService.deleteEmployeeById(employeeID);
    }
    @PostMapping("createNewEmployee/")
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody EmployeeDTO employeeDTO){
     return new ResponseEntity<EmployeeDTO>(employeeService.createNewEmployee(employeeDTO), HttpStatus.CREATED);
    }

    @PutMapping("updateEmployee/{employeeID}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long employeeID,@RequestBody EmployeeDTO employeeDTO){
        return new ResponseEntity<EmployeeDTO>(employeeService.updateEmployee(employeeID, employeeDTO), HttpStatus.OK);
    }

    @PostMapping("addEmployeeToLibrary/{employeeID}")
    public void addEmployeeToLibrary(@PathVariable Long employeeID, LibraryDTO libraryDTO){
        employeeService.addEmployeeToLibrary(employeeID, libraryDTO);
    }
}
