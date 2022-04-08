package com.ecommerce.controller;

import java.util.Optional;

import com.ecommerce.model.Category;
import com.ecommerce.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

// Control all the admin related routes


@Controller             //-> indicates that a particular class serves the role of a controller.
public class adminController {
    
@Autowired
    CategoryService categoryService;
    @GetMapping("/admin")       // -> Annotation for mapping HTTP GET requests onto specific handler methods. 
    public String adminHome() {
        return "adminHome";
    }

    @GetMapping("/admin/categories")
    public String getCategories(Model model) {
        model.addAttribute("categories",categoryService.getAllCategory());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String getCategoriesAdd(Model model) {
        model.addAttribute("category", new Category());             //blank Category Object was passed.
        return "categoriesAdd";
    }

    @PostMapping("/admin/categories/add")
    public String postCategoriesAdd(@ModelAttribute("category") Category categoryModel) {
        categoryService.addCateogry(categoryModel);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCategories(@PathVariable int id) {
            categoryService.removeCategoryById(id);
            return "redirect:/admin/categories";
    }

    @GetMapping("admin/categories/update/{id}")
    public String updateCategories(@PathVariable int id, Model model) {
                Optional<Category> category = categoryService.fetchCategoryById(id);
                if(category.isPresent()) {
                    model.addAttribute("category", category.get());
                    return "categoriesAdd";
                }
                else {
                    return "404";
                }
    }




}
