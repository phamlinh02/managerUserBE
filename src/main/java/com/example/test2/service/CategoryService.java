package com.example.test2.service;

import com.example.test2.model.Category;
import com.example.test2.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {
    Category saveCategory(Category category);
    List<Category> getAll();
    Category getCategoryById(int id);
    Category updateCategory(Category category, int id);
    void deleteCategory(int id);
}
