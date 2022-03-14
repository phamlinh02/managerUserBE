package com.example.test2.persitences;

import com.example.test2.model.Product;
import com.example.test2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface UserResponse extends JpaRepository<User, Integer> {

}
