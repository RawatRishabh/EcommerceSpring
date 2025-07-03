package com.example.EcommerceSpring.controllers;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.services.ICategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController
{

    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService)
    {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryDTO> getAllCategory() throws IOException{
       return this.categoryService.getAllCategory();
    }

}
