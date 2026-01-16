package com.product.service;
import com.product.dto.ProductDto;
import com.product.entity.Category;
import com.product.entity.Product;
import com.product.exception.CategoryNotFoundException;
import com.product.mapper.ProductMapper;
import com.product.repository.CategoryRepository;
import com.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService
{
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private    ProductRepository productRepository;
       public  ProductDto createProduct(ProductDto productDto)
       {
        Category category = categoryRepository.findById(productDto.getCategory()).orElseThrow(()-> new CategoryNotFoundException("Category "+productDto.getCategory()+"not found"));

          Product product = ProductMapper.toproductEntity( productDto,category);


                  product = productRepository.save(product);
                 return  ProductMapper.toproductDto(product);
       }
       public List<ProductDto> getAllProduct()
       {

           return productRepository.findAll().stream().map(ProductMapper::toproductDto).toList();

       }
      public ProductDto getProductById(Long id)
      {

          Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("data not found"));
          return ProductMapper.toproductDto(product);

      }

      public ProductDto updateProduct(Long id,ProductDto productdto)
      {
          Product product =  productRepository.findById(id).orElseThrow(()->new RuntimeException("update not done"));
          Category category =   categoryRepository.findById(productdto.getCategory()).orElseThrow(()->new RuntimeException("update not done"));

             product.setName(productdto.getName());
             product.setDescription(productdto.getDescription());
             product.setPrice(productdto.getPrice());
             product.setCategory(category);
             productRepository.save(product);
             return  ProductMapper.toproductDto(product);
      }
     public String deleteProduct(Long id)
     {
          productRepository.deleteById(id);
            return "product deleted";
     }
}
