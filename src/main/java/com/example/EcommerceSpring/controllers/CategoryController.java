package com.example.EcommerceSpring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController
{
    @GetMapping
    public String getCategory()
    {
        return "Electronics";
    }

    @PostMapping
    public String postCategory()
    {
        return "Post Electronics";
    }

    @GetMapping("/count") // If we call a GET request : /api/categories/count
    public int getCategoryCount()
    {
        return 6;
    }
}
