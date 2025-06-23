package com.example.accessing_data_mysql.repository;

import com.example.accessing_data_mysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterface extends JpaRepository<User, Long> {
}
