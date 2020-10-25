package com.example.demo.Service;


import com.example.demo.model.User;

import java.util.List;

public interface UserService1 {
    User save(User user);

    User findByUsername(String username);

    //List<String> findUsers(List<Long> idList);
}
