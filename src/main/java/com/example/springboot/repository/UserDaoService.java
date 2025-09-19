package com.example.springboot.repository;


import com.example.springboot.entity.UserBean;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static int count = 0;
    private static final List<UserBean> users = new ArrayList<>();
    static{
        users.add(new UserBean(++count,"Abhi", LocalDate.now().minusYears(30)));
        users.add(new UserBean(++count,"Likhitha", LocalDate.now().minusYears(21)));
        users.add(new UserBean(++count,"Eve", LocalDate.now().minusYears(28)));
    }

    //get
    public List<UserBean> findAll() {
        return users;
    }

    //get
    public UserBean findOne(Integer id) {
        Predicate<? super UserBean> predicate = user -> {
            return user.getId().equals(id);
        };
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    //post
    public UserBean addUser(UserBean user) {
        user.setId(++count);
        users.add(user);
        return user;
    }

}
