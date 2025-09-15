package com.example.learn_jpa_and_hibernate_demo.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn Spring Framework", "GPT"));
        repository.insert(new Course(2, "Learn Spring MVC", "Gemini"));
        repository.insert(new Course(3, "Learn Spring Boot", "Copilot"));
        repository.delete(2L);
        System.out.println(repository.select(3));
    }
}
