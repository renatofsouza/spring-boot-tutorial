package com.rs.springboot.tutorial.service;

import com.rs.springboot.tutorial.entity.Department;
import com.rs.springboot.tutorial.error.DepartmentNotFoundException;
import com.rs.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException {
        Optional<Department> department =  departmentRepository.findById(id);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department does not exist.");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department departmentDb = departmentRepository.findById(departmentId).get();
        if (Objects.nonNull(department.getDepartmentName())&&
        !"".equalsIgnoreCase(department.getDepartmentName())){
            departmentDb.setDepartmentName(department.getDepartmentName());
        }
        if (Objects.nonNull(department.getDepartmentCode())&&
                !"".equalsIgnoreCase(department.getDepartmentCode())){
            departmentDb.setDepartmentCode(department.getDepartmentCode());
        }
        if (Objects.nonNull(department.getDepartmentAddress())&&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){
            departmentDb.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepository.save(departmentDb);

    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
