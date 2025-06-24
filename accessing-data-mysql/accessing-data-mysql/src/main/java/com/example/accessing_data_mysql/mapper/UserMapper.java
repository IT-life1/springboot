package com.example.accessing_data_mysql.mapper;

import com.example.accessing_data_mysql.dto.UserDto;
import com.example.accessing_data_mysql.entity.User;

public class UserMapper {
    public static UserDto mapToDto(User user) {
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDto;
    }

    public static User mapToEntity(UserDto userDto) {
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        return user;
    }
}
