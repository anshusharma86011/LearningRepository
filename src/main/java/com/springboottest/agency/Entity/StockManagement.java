package com.springboottest.agency.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name= "stockManagement")
public class StockManagement {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int openingStock;

    private int purchaseQuantity;

    private int soldQuantity;

    private int closingStock;
}
