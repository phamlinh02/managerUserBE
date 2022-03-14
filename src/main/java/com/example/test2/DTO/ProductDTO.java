package com.example.test2.DTO;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// dto voi entity de khac thu muc nhe
@Getter
@Setter
public class ProductDTO {

    private int id;
    private String name;
    private String categoryName;
    private int quantity;


    public ProductDTO(int id, String name, String categoryName, int quantity) {
        this.id = id;
        this.name = name;
        this.categoryName = categoryName;
        this.quantity = quantity;
    }
}
