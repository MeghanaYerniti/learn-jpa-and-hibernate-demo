package com.example.springboot.service;

import com.example.springboot.entity.Course;
import com.example.springboot.repository.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJpaRepository repository;

//    @Autowired
//    private CourseJdbcRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn Spring Framework", "GPT"));
        repository.save(new Course(2, "Learn Spring MVC", "Gemini"));
        repository.save(new Course(3, "Learn Spring Boot", "Copilot"));
        repository.deleteById(2L);
        System.out.println(repository.findById(3L));
        System.out.println(repository.findByAuthor("GPT"));
    }
}

// url : http://localhost:8080/h2-console
