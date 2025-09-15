package com.example.learn_jpa_and_hibernate_demo.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String insert_Query =
            """
            insert into course (id, name, author) values (?,?,?);
            """;
    public void insert(Course c) { //can be any method name
        springJdbcTemplate.update(insert_Query, c.getId(), c.getName(), c.getAuthor());
    }

    private static String delete_Query =
            """
            delete from course where id = ?;
            """;
    public void delete(long id) { //can be any method name
        springJdbcTemplate.update(delete_Query, id);
    }

    private static String select_Query =
            """
            select * from course where id = ?;
            """;
    public Course select(long id) { //can be any method name
        // here new BeanPropertyRowMapper<>(Course.class) is used to store data retrieved from DB
        return springJdbcTemplate.queryForObject(select_Query,new BeanPropertyRowMapper<>(Course.class), id);
    }
}
