package com.abgassesment.service.implementation;

import java.util.List;
import java.util.Optional;

import com.abgassesment.model.Department;
import com.abgassesment.repository.AddressRepository;
import com.abgassesment.repository.DepartmentRepository;
import com.abgassesment.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

     @Autowired
    private AddressRepository addressRepository;

    @Override
    public Optional<Department> getDepartment(int id) {
      return this.departmentRepository.findById(id);
    }

    @Override
    public List<Department> getDepartments() {
        return this.departmentRepository.findAll();
    }

    @Override
    public Department addDepartment(Department department) {
        this.addressRepository.save(department.getAddress());
        return this.departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(int id, Department department) {
        department.setId(id);
        this.addressRepository.save(department.getAddress());
        return this.departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(int id) {
        this.departmentRepository.deleteById(id);
    }
    
}
