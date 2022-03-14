package com.example.test2.persitences;

import com.example.test2.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryResponse extends JpaRepository<Category, Integer> {


    @Query(value = "select sum((SELECT COUNT(a.id) FROM Product a WHERE a.category_id = c.id )) , c.id, c.name " +
            " from Product p join Category c on c.id = p.category_id " +
            "    where p.quantity = (SELECT COUNT(b.id) from Product b WHERE c.id = b.category_id) " +
            "    GROUP BY c.id" , nativeQuery = true)
    List<Category> findCategoryCompareProductQuantity();
}
