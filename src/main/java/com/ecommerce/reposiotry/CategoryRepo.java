package com.ecommerce.reposiotry;

import com.ecommerce.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
    
}
