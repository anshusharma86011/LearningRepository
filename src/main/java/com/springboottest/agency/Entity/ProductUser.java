package com.springboottest.agency.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
@Table(name = "products")
public class ProductUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long productId;

     @Column(nullable = false)
     private String productName;
    
     @Column(nullable = false, unique = true)
     private String productCode;

    // @Column(nullable = false)
     private Integer quantity;

//@Column(nullable = false)
     private String Unit;

     @Column(nullable = false)
     private Integer productStock;

     @Column(nullable = false)
     private Double productPrice;



     @Column(name = "total_Price")
     private Double totalPrice;
    public Double getTotalPrice() {
        double totalPrice1 = 0;
        if (productPrice != null && productStock != null) {
            totalPrice1 = (int) (productPrice * productStock);
        }
        return totalPrice1;
    }

     // ✅ Default constructor (VERY IMPORTANT)
    public ProductUser() {
    }

    
}