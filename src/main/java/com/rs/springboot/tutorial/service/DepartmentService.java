package com.rs.springboot.tutorial.service;

import com.rs.springboot.tutorial.entity.Department;
import com.rs.springboot.tutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long id);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
