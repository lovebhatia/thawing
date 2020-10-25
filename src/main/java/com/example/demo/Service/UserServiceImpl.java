package com.example.demo.Service;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService1 {

    @Autowired
    private UserRepository userRepository;
    //we will create bean for it in security config.
    //@Autowired
    private PasswordEncoder passwordEncoder;

    public User save(User user) {
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }


   // @Override
    //public List<String> findUsers(List<Long> idList) {
        //return userRepository.findByIdList(idList);
    //}

}
