package com.abgassesment.service.implementation;

import java.util.List;
import java.util.Optional;

import com.abgassesment.model.Employee;
import com.abgassesment.repository.AddressRepository;
import com.abgassesment.repository.EmployeeRepository;
import com.abgassesment.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;
     @Autowired
    private AddressRepository addressRepository;

    @Override
    public Optional<Employee> getEmployee(long empId) {
      return this.employeeRepository.findById(empId);
    }

    @Override
    public List<Employee> getEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        this.addressRepository.save(employee.getAddress());
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(long empId, Employee employee) {
        employee.setEmpId(empId);
        this.addressRepository.save(employee.getAddress());
        return this.employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(long empId) {
        this.employeeRepository.deleteById(empId);
    }




}
