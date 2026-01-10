package com.springboottest.agency.Dto;

import lombok.Data;

@Data
public class ProductUpdateRequest {

    private String productName;
    private String productCode;
    private Double productPrice;
    private Integer productStock;
    private Integer quantity;
    private String unit;
   
       
}
