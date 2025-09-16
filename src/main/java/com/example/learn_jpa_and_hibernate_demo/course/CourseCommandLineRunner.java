package com.example.learn_jpa_and_hibernate_demo.course;

import com.example.learn_jpa_and_hibernate_demo.course.jdbc.CourseJdbcRepository;
import com.example.learn_jpa_and_hibernate_demo.course.jpa.CourseJpaRepository;
import com.example.learn_jpa_and_hibernate_demo.course.springdatajpa.CourseSpringDataJpaRepository;
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
