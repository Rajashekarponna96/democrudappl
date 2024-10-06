package com.DemoSpringboot.Demo.serviceImpl;
 
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.DemoSpringboot.Demo.mapper.EmployeeMapper;
import com.DemoSpringboot.Demo.model.Employee;
import com.DemoSpringboot.Demo.repository.EmployeeRepository;
import com.DemoSpringboot.Demo.requestDto.EmployeeRequest;
import com.DemoSpringboot.Demo.responseDto.EmployeeResponse;
import com.DemoSpringboot.Demo.service.EmployeeService; 

@Service
public class EmployeeServiceImpl implements EmployeeService {

 private final EmployeeRepository employeeRepository;
 private final EmployeeMapper employeeMapper;

 public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
     this.employeeRepository = employeeRepository;
     this.employeeMapper = employeeMapper;
 }

 @Override
 public EmployeeResponse createEmployee(EmployeeRequest request) {
     Employee employee = employeeMapper.toEntity(request);
     Employee savedEmployee = employeeRepository.save(employee);
     return employeeMapper.toResponse(savedEmployee);
 }

 @Override
 public EmployeeResponse getEmployeeById(Long id) {
     Employee employee = employeeRepository.findById(id)
             .orElseThrow(() -> new RuntimeException("Employee not found"));
     return employeeMapper.toResponse(employee);
 }

 @Override
 public EmployeeResponse updateEmployee(Long id, EmployeeRequest request) {
     Employee employee = employeeRepository.findById(id)
             .orElseThrow(() -> new RuntimeException("Employee not found"));

     employee.setName(request.getName());
     employee.setEmail(request.getEmail());
     employee.setDepartment(request.getDepartment());

     Employee updatedEmployee = employeeRepository.save(employee);
     return employeeMapper.toResponse(updatedEmployee);
 }

 @Override
 public void deleteEmployee(Long id) {
     Employee employee = employeeRepository.findById(id)
             .orElseThrow(() -> new RuntimeException("Employee not found"));
     employeeRepository.delete(employee);
 }

 @Override
 public List<EmployeeResponse> getAllEmployees() {
     return employeeRepository.findAll()
             .stream()
             .map(employeeMapper::toResponse)
             .collect(Collectors.toList());
 }
}
