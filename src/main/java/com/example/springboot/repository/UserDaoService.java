package com.example.springboot.repository;


import com.example.springboot.entity.UserBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static final List<UserBean> users = new ArrayList<>();
    static{
        users.add(new UserBean(1,"Abhi", LocalDate.now().minusYears(30)));
        users.add(new UserBean(2,"Likhitha", LocalDate.now().minusYears(21)));
        users.add(new UserBean(3,"Eve", LocalDate.now().minusYears(28)));
    }

    public List<UserBean> findAll() {
        return users;
    }

    public UserBean findOne(Integer id) {
        Predicate<? super UserBean> predicate = user -> {
            return user.getId().equals(id);
        };
        return users.stream().filter(predicate).findFirst().get();
    }
}
