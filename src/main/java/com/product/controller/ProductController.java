package com.product.controller;

import com.product.dto.ProductDto;
import com.product.entity.Product;
import com.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name ="Product Api",
        description = "Insert ,update ,delete and create also"
)


@RestController
@RequestMapping("api/product")
@EnableMethodSecurity(prePostEnabled = true)
public class ProductController {
    @Autowired
    private ProductService productService;

    @Operation
            (
                    summary = "create product in RestApi ",
                    description = "Create category by Name,description,price,category"
            )

    //crate product
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        ProductDto createproduct = productService.createProduct(productDto);
        return new ResponseEntity<>(createproduct, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ProductDto getProductDto(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    //fetch all product
    @GetMapping
    public List<ProductDto> getAllProduct() {
        return productService.getAllProduct();
    }

    //update product
//      @PutMapping("/{id}")
//      public ProductDto updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto)
//      {
//           return   productService.updateProduct(id,productDto);
//      }
    // update product
    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto) {
        // Explicitly using ("id") maps the {id} from the URL to the parameter 'id'
        return productService.updateProduct(id, productDto);
    }

    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    //delete product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

}
