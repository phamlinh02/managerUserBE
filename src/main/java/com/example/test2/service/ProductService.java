package com.example.test2.service;

import com.example.test2.model.Product;
import com.example.test2.DTO.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product saveProduct(Product product);
    List<Product> getAll();
    Product getProductById(int id);
    Product updateProduct(Product product, int id);
    void deleteProduct(int id);
    List<ProductDTO> getList();
    List<Product> getTop5();




}
