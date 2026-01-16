package com.product.repository;

import com.product.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long>
{
   Optional<Category> findByName(String  CategoryName);

}
