package com.abgassesment.service;

import java.util.List;
import java.util.Optional;

import com.abgassesment.model.Department;

public interface DepartmentService {

    public Optional<Department> getDepartment(int id);

    public List<Department> getDepartments();
    
    public Department addDepartment(Department Department);

    public Department updateDepartment(int id, Department Department);

    public void deleteDepartment(int id);

    
}
