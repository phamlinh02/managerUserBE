package com.example.test2.controller;


import com.example.test2.model.Product;
import com.example.test2.DTO.ProductDTO;
import com.example.test2.persitences.ProductResponse;
import com.example.test2.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {

    private ProductResponse responsePro;

    private ProductService productService;


    public ProductController(ProductService productService, ProductResponse productResponse) {

        this.productService = productService;
        this.responsePro = productResponse;

    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> listAll() {

        List<Product> listProduct = responsePro.findAll();
//        model.addAttribute("list", listProduct);
//        return "product";
        return listProduct;
    }

    @GetMapping("/")
    public List<ProductDTO> getAll() {
        List<ProductDTO> lst = productService.getList();
        return lst;
    }

    @GetMapping("/top5")
    public List<Product> getTop5() {
//        List<Product> lst = productService.getTop5();
        List<Product> lst = responsePro.findTop5ByOrderByQuantity();
        return lst;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int productId) {
        return new ResponseEntity<Product>(productService.getProductById(productId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") int id
            , @RequestBody Product product) {
        return new ResponseEntity<Product>(productService.updateProduct(product, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) {

        // delete product from DB
        productService.deleteProduct(id);

        return new ResponseEntity<String>("Product deleted successfully!.", HttpStatus.OK);
    }

}
