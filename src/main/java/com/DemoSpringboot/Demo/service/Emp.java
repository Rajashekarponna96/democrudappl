package com.DemoSpringboot.Demo.service;

import org.springframework.stereotype.Service;

import com.DemoSpringboot.Demo.model.Employee;

@Service
public interface Emp {

	public void add(Employee emp);

	public void get(Employee emp);
	

}
