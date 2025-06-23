package com.example.accessing_data_mysql.service.impl;

import com.example.accessing_data_mysql.entity.User;
import com.example.accessing_data_mysql.repository.UserInterface;
import com.example.accessing_data_mysql.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceIml implements UserService {

    private UserInterface userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }
}
