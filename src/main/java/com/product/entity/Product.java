package com.product.entity;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long  id;
    private String name;
    private String description;
    private double price;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "category_id" ,nullable=false)
    private Category category;

}
