package com.DemoSpringboot.Demo.service;

import java.util.List;

import com.DemoSpringboot.Demo.requestDto.EmployeeRequest;
import com.DemoSpringboot.Demo.responseDto.EmployeeResponse;

public interface EmployeeService {
    EmployeeResponse createEmployee(EmployeeRequest request);
    EmployeeResponse getEmployeeById(Long id);
    EmployeeResponse updateEmployee(Long id, EmployeeRequest request);
    void deleteEmployee(Long id);
    List<EmployeeResponse> getAllEmployees();
}