package com.example.accessing_data_mysql.service;

import com.example.accessing_data_mysql.dto.UserDto;
import com.example.accessing_data_mysql.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto findUserById(long id);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto user);
    void deleteUserById(long id);
}
