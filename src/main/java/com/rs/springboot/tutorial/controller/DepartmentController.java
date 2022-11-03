package com.rs.springboot.tutorial.controller;

import com.rs.springboot.tutorial.entity.Department;
import com.rs.springboot.tutorial.error.DepartmentNotFoundException;
import com.rs.springboot.tutorial.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of Department Controller");
        return departmentService.saveDepartment(department);
    }

    @GetMapping()
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside fetchDepartmentList of Department Controller");
        return departmentService.fetchDepartmentList();
    }
    @GetMapping("{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteDepartmentById(@PathVariable("id") Long id){
        departmentService.deleteDepartmentById(id);

    }

    @PutMapping("{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("name/{departmentName}")
    public Department fechDepartmentByName(@PathVariable("departmentName") String deparmentName){
        return departmentService.fetchDepartmentByName(deparmentName);
    }
}
