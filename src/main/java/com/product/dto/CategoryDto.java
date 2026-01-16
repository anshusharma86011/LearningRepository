package com.product.dto;
import com.product.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;



@Schema
        (
                name = "Category",
                description = "it hold category information along with description"
        )

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto
{

    private Long id;
    private String name;

    private List<ProductDto> product;

}
