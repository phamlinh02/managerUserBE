package com.example.test2.respositories;

import javax.persistence.*;

import com.example.test2.model.Product;
import com.example.test2.DTO.ProductDTO;
import com.example.test2.persitences.ProductResponse;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRepositories {

    @PersistenceContext
    private EntityManager em;

    private ProductResponse productRespone;

    public ProductRepositories(ProductResponse productResponse) {
        super();
        this.productRespone = productResponse;
    }

    public List<ProductDTO> getAll() {
        String hql = "SELECT a.id as ID, a.name as Name, b.name as CategoryName, a.quantity as Quantity FROM Product a join Category b on a.category_id = b.id" +
                "   where a.quantity > 3";
        Query query = em.createNativeQuery(hql, "SelectProductAndCategory");

        return query.getResultList();
    }

    public List<Product> getTop5() {
        // cho nay cung dung thu jpa thuan cho a nhe

        String hql = "select a from Product  a  order by a.quantity  ";

        TypedQuery<Product> query = em.createQuery(hql, Product.class);

        query.setMaxResults(5);

        return query.getResultList();
    }




}
