package com.example.learn_jpa_and_hibernate_demo.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String insert_Query =
            """
            insert into course (id, name, author) values (1,'Learn Spring', 'GPT');
            """;
    public void insert() { //can be any method name
        springJdbcTemplate.update(insert_Query);
    }
}
