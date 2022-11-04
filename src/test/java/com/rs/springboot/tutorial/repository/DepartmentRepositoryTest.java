package com.rs.springboot.tutorial.repository;

import com.rs.springboot.tutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("Mechanical Engineering")
                        .departmentCode("ME-07")
                        .departmentAddress("Alachua")
                        .build();
        entityManager.persist(department);

    }

    @Test
    public void whenFindById_thenReturnDepartment(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(),"Mechanical Engineering");

    }
}