package com.example.accessing_data_mysql.service.impl;

import com.example.accessing_data_mysql.dto.UserDto;
import com.example.accessing_data_mysql.entity.User;
import com.example.accessing_data_mysql.mapper.UserMapper;
import com.example.accessing_data_mysql.repository.UserInterface;
import com.example.accessing_data_mysql.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceIml implements UserService {

    private UserInterface userRepository;
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        // Convert UserDto to JPA Entity
        // User user = UserMapper.mapToEntity(userDto);
        User user = modelMapper.map(userDto, User.class);

        User savedUser = userRepository.save(user);

        // Convert JPA Entity to UserDto
        // UserDto savedUserDto = UserMapper.mapToDto(savedUser);

        UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

        return savedUserDto;
    }

    @Override
    public UserDto findUserById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.get();
        // return UserMapper.mapToDto(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        // return users.stream().map(UserMapper::mapToDto)
        //        .collect(Collectors.toList());
        return users.stream().map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        // return UserMapper.mapToDto(userRepository.save(existingUser));
        return modelMapper.map(userRepository.save(existingUser), UserDto.class);
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }
}
