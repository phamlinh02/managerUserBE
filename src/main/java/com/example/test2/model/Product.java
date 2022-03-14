package com.example.test2.model;


import com.example.test2.DTO.ProductDTO;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "product")
@Entity
@SqlResultSetMapping(
        name = "SelectProductAndCategory",
        classes = {
                @ConstructorResult(
                        targetClass = ProductDTO.class,
                        columns = {
                                @ColumnResult(name = "ID", type = Integer.class),
                                @ColumnResult(name = "Name", type = String.class),
                                @ColumnResult(name = "CategoryName", type = String.class),
                                @ColumnResult(name = "quantity", type = Integer.class)
                        }
                )
        }
)
@SqlResultSetMapping(
        name = "abc",
        classes = {
                @ConstructorResult(
                        targetClass = ProductDTO.class,
                        columns = {
                                @ColumnResult(name = "ID", type = Integer.class),
                                @ColumnResult(name = "Name", type = String.class),
                                @ColumnResult(name = "CategoryName", type = String.class)
                        }
                )
        }
)
//@NamedNativeQuery(
//        name = "GetListAll",
//        query = "SELECT a.id as ID, a.name as Name, b.name as CategoryName, a.quantity as Quantity FROM Product a join Category b on a.category_id = b.id ",
//        resultSetMapping = "SelectProductAndCategory"
//)
public  class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private String name;
    private int quantity;
    private int category_id;


}
