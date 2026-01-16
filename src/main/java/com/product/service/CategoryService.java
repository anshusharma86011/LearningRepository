package com.product.service;
import com.product.dto.CategoryDto;
import com.product.entity.Category;
import com.product.exception.CategoryAlreadyExistException;
import com.product.mapper.CategoryMapper;
import com.product.repository.CategoryRepository;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService
{

       @Autowired
       private CategoryRepository categoryRepository ;
      public CategoryDto createCategory(CategoryDto categoryDto )
      {
                 Optional<Category> optionalcategory = categoryRepository.findByName(categoryDto.getName());
                 if(optionalcategory.isPresent())
                 {
                     throw  new  CategoryAlreadyExistException("Category already exist");
                 }
          Category category = CategoryMapper.toCategoryEntity(categoryDto);
           category =  categoryRepository.save(category);
             return CategoryMapper.categoryDto(category);
      }
      public List<CategoryDto> getAllCategory()
      {
           return categoryRepository.findAll().stream().map(CategoryMapper::categoryDto).toList();


      }
     public CategoryDto getCategoryById(   Long id)
     {
       Category category =   categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("data not found"));
                     return CategoryMapper.categoryDto(category);
     }

     public String deleteCategoryById(Long id)
     {
             categoryRepository.deleteById(id);
             return "data successfully deleted";
     }

}
