package com.abgassesment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.abgassesment.dto.EmployeeDto;
import com.abgassesment.dto.EmployeeUpdateDto;
import com.abgassesment.model.Employee;
import com.abgassesment.service.DepartmentService;
import com.abgassesment.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/employee")
public class EmployeeContoller {


    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;


    @PostMapping("/")
    public Employee addEmployee(@RequestBody EmployeeDto employeeDto) {
       Employee employee = new Employee();
       employee.setEmpId(employeeDto.getEmpId());
       employee.setName(employeeDto.getName());
       employee.setAddress(employeeDto.getAddress());
       employee.setMobileNumber(employeeDto.getMobileNumber());
       employee.setSalary(employeeDto.getSalary());
       employee.setDepartment(this.departmentService.getDepartment(employeeDto.getDepartmentId()).get());
       return this.employeeService.addEmployee(employee);
    }


    @PutMapping("/{id}")
    public Employee updateEmployee( @PathVariable("id") long empId,@RequestBody EmployeeUpdateDto employeeUpdateDto){
        Employee employee = this.employeeService.getEmployee(empId).get();
        if(employeeUpdateDto.getMobileNumber() != 0){
            employee.setMobileNumber(employeeUpdateDto.getMobileNumber());
        } 
        if(employeeUpdateDto.getAddress() != null){
            employee.setAddress(employeeUpdateDto.getAddress());
        }
        return this.employeeService.updateEmployee(empId, employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") long empId){
        return this.employeeService.getEmployee(empId).get();
    }
    
    @GetMapping("/")
    public List<Employee> getEmployee(){
        return this.employeeService.getEmployees();
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") long empId){
         this.employeeService.deleteEmployee(empId);
    }
    
}
