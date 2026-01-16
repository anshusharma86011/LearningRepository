package com.product.controller;
import com.product.dto.CategoryDto;
import com.product.exception.CategoryAlreadyExistException;
import com.product.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name =" Category Api",
        description = "Insert ,update ,delete and create also"
)


@RestController
@RequestMapping("api/category")
public class CategoryController
{
    @Autowired
   private CategoryService categoryService;

    @Operation
            (
              summary = "create category in RestApi by CategoryId",
              description = "Create category by Name"
            )

    //CreateCategory
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping

    public ResponseEntity<?> createCategory(@RequestBody CategoryDto categoryDto)
        {

                CategoryDto category = categoryService.createCategory(categoryDto);
                return ResponseEntity.status(HttpStatus.CREATED).body(category);

          //  return new ResponseEntity<>(categoryService.createCategory(categoryDto),  HttpStatus.CREATED);

        }
        //getAllCategory
        @Operation
                (
                        summary = "getAllCategory in RestApi",
                        description = "Create category by Name"
                )

      @GetMapping
        public List<CategoryDto>  getAllCategory()
        {

              return  categoryService.getAllCategory();

        }



    @Operation
            (
                    summary = "get category in RestApi by CategoryId",
                    description = "get category by CategoryId"
            )
        //getCategory with id
        @GetMapping("/{id}")
        public CategoryDto getCategoryById(@PathVariable Long id)
        {
              return categoryService.getCategoryById(id);
        }

    @Operation
            (
                    summary = "delete category in RestApi by CategoryId",
                    description = "delete category by CategoryId"
            )
        //delete category
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
       @DeleteMapping("/{id}")
       public String deleteById(@PathVariable Long id)
       {
           return categoryService.deleteCategoryById(id);
       }

}
