package com.DemoSpringboot.Demo.mapper;
import org.springframework.stereotype.Component;

import com.DemoSpringboot.Demo.model.Employee;
import com.DemoSpringboot.Demo.requestDto.EmployeeRequest;
import com.DemoSpringboot.Demo.responseDto.EmployeeResponse;

@Component
public class EmployeeMapper {

    public Employee toEntity(EmployeeRequest request) {
        return new Employee(null, request.getName(), request.getEmail(), request.getDepartment());
    }

    public EmployeeResponse toResponse(Employee employee) {
        return new EmployeeResponse(employee.getId(), employee.getName(), employee.getEmail(), employee.getDepartment());
    }
}
