package com.example.jpa1to1.repository;

import com.example.jpa1to1.model.Employee;
import org.hibernate.JDBCException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    void testAtLeastOneJens() {
        List<Employee>  lst = employeeRepository.findEmployeeByName("Jens");
        assertTrue(lst.size()>0);
    }

    @Test
    void testDeleteUser() {
        //Denne test forudsætter at InitData har kørt
        //Vi har en user og en employee i databasen
        //Vi vil her teste at vi IKKE kan slette en user der har en employee
        List<Employee>  lst = employeeRepository.findEmployeeByName("Jens");
        Employee emp1 = lst.get(0);
        assertEquals("Jens", emp1.getName());
        //userRepository.delete(emp1.getUser());
        assertThrows(InvalidDataAccessApiUsageException.class, () -> userRepository.delete(emp1.getUser()));

    }
}