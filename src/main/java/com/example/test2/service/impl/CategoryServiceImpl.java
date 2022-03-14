package com.example.test2.service.impl;

import com.example.test2.exception.ResourceNotFoundException;
import com.example.test2.model.Category;
import com.example.test2.model.Product;
import com.example.test2.persitences.CategoryResponse;
import com.example.test2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryResponse categoryResponse;

    @Override
    public Category saveCategory(Category category){
        return categoryResponse.save(category);
    }

    @Override
    public List<Category> getAll(){
        return categoryResponse.findAll();
    };

    @Override
    public Category getCategoryById(int id){
        return  categoryResponse.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Category", "Id", id));
    };
    @Override
    public Category updateCategory(Category category, int id){
        // we need to check whether employee with given id is exist in DB or not
        Category category1 = categoryResponse.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Category", "Id", id));

        category1.setName(category.getName());

        // save existing employee to DB
        categoryResponse.save(category1);
        return category1;
    };
    @Override
    public void deleteCategory(int id){
        categoryResponse.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Product", "Id", id));
        categoryResponse.deleteById(id);
    };




}
