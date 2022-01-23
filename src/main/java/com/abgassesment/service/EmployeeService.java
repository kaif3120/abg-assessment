package com.abgassesment.service;

import java.util.List;
import java.util.Optional;

import com.abgassesment.model.Employee;

public interface EmployeeService {

    public Optional<Employee> getEmployee(long empId);

    public List<Employee> getEmployees();
    
    public Employee addEmployee(Employee employee);

    public Employee updateEmployee(long empId, Employee employee);

    public void deleteEmployee(long empId);
    
}
