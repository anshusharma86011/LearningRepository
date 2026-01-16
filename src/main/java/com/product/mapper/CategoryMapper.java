package com.product.mapper;

import com.product.dto.CategoryDto;
import com.product.entity.Category;

public class CategoryMapper
{

    public static CategoryDto categoryDto(Category category)
    {
        if(category==null)
        {
           return null;
        }

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setProduct(category.getProduct().stream().map(ProductMapper::toproductDto).toList());
        return  categoryDto;

    }


     public  static Category toCategoryEntity(CategoryDto categoryDto)
     {
         Category category = new Category();
         category.setName(categoryDto.getName());
         return category;
     }

}
