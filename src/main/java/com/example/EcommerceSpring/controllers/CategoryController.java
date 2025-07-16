package com.example.EcommerceSpring.controllers;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.ProductsDTO;
import com.example.EcommerceSpring.services.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<List<CategoryDTO>> getAllCategory() throws IOException{
       List<CategoryDTO> response =  this.categoryService.getAllCategory();
       return ResponseEntity.ok(response);
    }

    @GetMapping(params = {"type","sort"})
    public ResponseEntity<List<ProductsDTO>> getCategoryProduct(@RequestParam("type") String product, @RequestParam("sort") String order) throws Exception {
        List<ProductsDTO> response = this.categoryService.getCategoryProduct(product,order);
        return ResponseEntity.ok(response);
    }
}
