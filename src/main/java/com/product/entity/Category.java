package com.product.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @OneToMany(mappedBy = "category",cascade =CascadeType.ALL ,fetch =FetchType.LAZY)
    private List<Product> product = new ArrayList();


}
