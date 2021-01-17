package com.nolesiak.bookstoreapp.services;

import com.nolesiak.bookstoreapp.api.mapper.BookMapper;
import com.nolesiak.bookstoreapp.api.mapper.CustomerMapper;
import com.nolesiak.bookstoreapp.api.mapper.EmployeeMapper;
import com.nolesiak.bookstoreapp.api.mapper.LibraryMapper;
import com.nolesiak.bookstoreapp.api.model.EmployeeDTO;
import com.nolesiak.bookstoreapp.api.model.LibraryDTO;
import com.nolesiak.bookstoreapp.domain.Employee;
import com.nolesiak.bookstoreapp.repositories.CustomerRepository;
import com.nolesiak.bookstoreapp.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeRepository employeeRepository;
    EmployeeMapper employeeMapper;
    LibraryMapper libraryMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper, LibraryMapper libraryMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.libraryMapper = libraryMapper;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
    return employeeRepository.findAll().stream().map(employeeMapper::employeeToEmployeeDTO).collect(Collectors.toList());

    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeID) {
        return employeeRepository.findById(employeeID).map(employeeMapper::employeeToEmployeeDTO).get();
    }

    @Override
    public void deleteEmployeeById(Long employeeID) {
        employeeRepository.deleteById(employeeID);
    }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.employeeDTOToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.employeeToEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO updateEmployee(Long employeeID, EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.employeeDTOToEmployee(employeeDTO);
        employee.setId(employeeID);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.employeeToEmployeeDTO(savedEmployee);
    }

    @Override
    public void addEmployeeToLibrary(Long employeeID, LibraryDTO libraryDTO) {
        var employeeDTO = getEmployeeById(employeeID);
        var mappedEmployee = employeeMapper.employeeDTOToEmployee(employeeDTO);
        var mappedLibrary=libraryMapper.libraryDTOToLibrary(libraryDTO);
        mappedEmployee.setLibrary(mappedLibrary);
        employeeRepository.save(mappedEmployee);
    }
}
