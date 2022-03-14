package com.example.test2.controller;


import com.example.test2.model.Category;
import com.example.test2.model.Product;
import com.example.test2.persitences.CategoryResponse;
import com.example.test2.persitences.ProductResponse;
import com.example.test2.service.CategoryService;
import com.example.test2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryResponse categoryResponse;

    private CategoryService categoryService;


    @Autowired
    private CategoryResponse responseCate;

    public CategoryController(CategoryService categoryService){

        this.categoryService = categoryService;

    }

    @GetMapping
    public List<Category> listAll() {

        List<Category> list = responseCate.findAll();
//        model.addAttribute("list", listProduct);
//        return "product";
        return list;
    }


    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        return  new ResponseEntity<Category>(categoryService.saveCategory(category), HttpStatus.CREATED);

    }
    @GetMapping("{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") int id){
        return new ResponseEntity<Category>(categoryService.getCategoryById(id), HttpStatus.OK);
    }

    @GetMapping("/same")
    public  List<Category> getCategorySame() {
        List<Category> lst = responseCate.findCategoryCompareProductQuantity();
        return  lst;
    }

    @PutMapping("{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") int id
            ,@RequestBody Category category){
        return new ResponseEntity<Category>(categoryService.updateCategory(category, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") int id){

        // delete product from DB
        categoryService.deleteCategory(id);

        return new ResponseEntity<String>("Category deleted successfully!.", HttpStatus.OK);
    }
}
