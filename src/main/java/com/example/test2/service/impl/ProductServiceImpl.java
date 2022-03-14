package com.example.test2.service.impl;

import com.example.test2.exception.ResourceNotFoundException;
import com.example.test2.model.Product;
import com.example.test2.DTO.ProductDTO;
import com.example.test2.persitences.ProductResponse;
import com.example.test2.respositories.ProductRepositories;
import com.example.test2.service.ProductService;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    public ProductServiceImpl(ProductResponse productResponse, ProductRepositories productRepositories) {
        this.productResponse = productResponse;
        this.productRepositories = productRepositories;
    }


    private final ProductResponse productResponse;
    private final ProductRepositories productRepositories;

    @Override
    public Product saveProduct(Product product) {
        return productResponse.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productResponse.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productResponse.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "Id", id));
    }

    @Override
    public Product updateProduct(Product product, int id) {
        // we need to check whether employee with given id is exist in DB or not
        Product pro = productResponse.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "Id", id));

        pro.setName(pro.getName());
        pro.setCategory_id(pro.getCategory_id());
        pro.setQuantity(pro.getQuantity());
        // save existing employee to DB
        productResponse.save(pro);
        return pro;
    }

    @Override
    public void deleteProduct(int id) {
        productResponse.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "Id", id));
        productResponse.deleteById(id);
    }



    public List<ProductDTO> getList() {
        return productRepositories.getAll();
    }

    @Transactional
    public List<Product> getTop5() {
        return productRepositories.getTop5();
    }



}
