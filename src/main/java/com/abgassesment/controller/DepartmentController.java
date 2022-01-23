package com.abgassesment.controller;

import java.util.List;

import com.abgassesment.model.Department;
import com.abgassesment.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;

   

    @GetMapping("/")
    public List<Department> getDepartments(){
       return this.departmentService.getDepartments();
    }

     @GetMapping("/{id}")
    public Department getDepartment(@PathVariable("id") int id){
       return this.departmentService.getDepartment(id).get();
    }

    @PostMapping("/")
    public Department addDepartment(@RequestBody Department department){
        return this.departmentService.addDepartment(department);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable("id") int id,@RequestBody Department department){
        return this.departmentService.updateDepartment(id,department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable("id") int id){
         this.departmentService.deleteDepartment(id);
    }



}
