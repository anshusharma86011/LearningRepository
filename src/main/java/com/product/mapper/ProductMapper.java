package com.product.mapper;

import com.product.dto.ProductDto;
import com.product.entity.Category;
import com.product.entity.Product;

public class ProductMapper
{
   public static ProductDto toproductDto(Product product)
   {
            return  new ProductDto
              (
                      product.getId(),
                      product.getName(),
                      product.getDescription(),
                      product.getPrice(),
                      product.getCategory().getId()
               );

   }

   public static Product toproductEntity(ProductDto productDto,Category category)
   {
            Product product = new Product();
            product.setName(productDto.getName());
            product.setDescription(productDto.getDescription());
            product.setPrice(productDto.getPrice());
            product.setCategory(category);
            return product;
   }
}
