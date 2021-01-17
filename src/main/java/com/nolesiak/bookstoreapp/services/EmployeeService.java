package com.nolesiak.bookstoreapp.services;

import com.nolesiak.bookstoreapp.api.model.EmployeeDTO;
import com.nolesiak.bookstoreapp.api.model.LibraryDTO;
import com.nolesiak.bookstoreapp.domain.Employee;
import com.nolesiak.bookstoreapp.domain.Library;

import java.util.List;

public interface EmployeeService {

   List<EmployeeDTO> getAllEmployees();
   EmployeeDTO getEmployeeById(Long employeeID);
   void deleteEmployeeById(Long employeeID);
   EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO);
   EmployeeDTO updateEmployee(Long employeeID, EmployeeDTO employeeDTO);
   void addEmployeeToLibrary(Long employeeID, LibraryDTO libraryDTO);
}
