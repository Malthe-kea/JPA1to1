package com.example.jpa1to1.config;

import com.example.jpa1to1.model.Employee;
import com.example.jpa1to1.model.Gender;
import com.example.jpa1to1.model.User;
import com.example.jpa1to1.repository.EmployeeRepository;
import com.example.jpa1to1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {

        User us1 = new User();
        us1.setEmail("12312@lkjsdf.dk");
        us1.setPassword("asdasd");
        userRepository.save(us1);

        us1.setUserID(0);
        us1.setEmail("aske@jada.dk");
        us1.setPassword("asda59834h");
        userRepository.save(us1);

        us1.setUserID(0);
        us1.setEmail("malthe@snabnel.a");
        us1.setPassword("asda512315sdfas");
        userRepository.save(us1);

        Employee emp1 = new Employee();
        emp1.setBorn(LocalDateTime.of(1990, 5, 24, 12,0));
        emp1.setName("Jens");
        emp1.setGender(Gender.MALE);
        emp1.setVegetarian(true);
        emp1.setUser(us1);
        employeeRepository.save(emp1);
    }
}
