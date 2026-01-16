package com.product.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Schema
        (
                name = "Product",
                description = "it hold product information "
        )

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto
{


    private Long id;
    private String name;
    private String description;
    private double price;
    private Long category;


}
