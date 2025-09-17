package com.example.springboot.repository;

import com.example.springboot.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional // used when we execute query using JPA
public class CourseJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course) {
        entityManager.merge(course);
        // here mapping is done automatically
        // merge() => insertion
    }

    public Course select(Long id) {
        return entityManager.find(Course.class, id);
        // find() => select statement
    }

    public void delete(Long id) {
        entityManager.remove(entityManager.find(Course.class, id));
        // remove() => delete
    }
}
