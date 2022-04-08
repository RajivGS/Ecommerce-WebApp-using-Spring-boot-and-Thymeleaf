package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.model.Category;
import com.ecommerce.reposiotry.CategoryRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo category_repo;

    public List<Category> getAllCategory(){
        return category_repo.findAll();
    }

    public void addCateogry(Category categoryModel) {
            category_repo.save(categoryModel);
    }
    
    public void removeCategoryById(int id){
        category_repo.deleteById(id);
    }

    public Optional<Category> fetchCategoryById(int id) {
        return category_repo.findById(id);
    }

}
