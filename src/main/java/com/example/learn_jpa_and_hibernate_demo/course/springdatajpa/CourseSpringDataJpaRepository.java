package com.example.learn_jpa_and_hibernate_demo.course.springdatajpa;

import com.example.learn_jpa_and_hibernate_demo.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
    List<Course> findByAuthor(String author);
}
