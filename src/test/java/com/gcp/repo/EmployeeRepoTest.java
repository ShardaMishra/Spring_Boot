package com.gcp.repo;

import com.gcp.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
public class EmployeeRepoTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    EmployeeRepo employeeRepo;

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = Employee.builder()
                .empName("Sharda")
                .build();
        entityManager.persist(employee);
    }

    @Test
    public void findEmployeeById() {
        Employee emp = employeeRepo.findById(1L).get();
        assertEquals("Sharda", emp.getEmpName());
    }
}


