package com.example.accessing_data_mysql.service;

import com.example.accessing_data_mysql.entity.User;

public interface UserService {
    User createUser(User user);
    User findUserById(long id);
}
