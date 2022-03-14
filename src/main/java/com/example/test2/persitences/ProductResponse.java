package com.example.test2.persitences;

import com.example.test2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;


@EnableJpaRepositories
public interface ProductResponse extends JpaRepository<Product, Integer> {
    List<Product> findTop5ByOrderByQuantity();
}
