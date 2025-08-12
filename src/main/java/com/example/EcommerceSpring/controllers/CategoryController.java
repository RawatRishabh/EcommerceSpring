package com.example.EcommerceSpring.controllers;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.services.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> getAllCategory(@RequestParam(required = false) String name) throws Exception {
        if(name!=null && name!=""){
            CategoryDTO categoryDTO = categoryService.findByName(name);
            return  ResponseEntity.ok(categoryDTO);
        }
            else{
            List<CategoryDTO> response =  this.categoryService.getAllCategory();
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping(params = {"type","sort"})
    public ResponseEntity<List<ProductDTO>> getCategoryProduct(@RequestParam("type") String product, @RequestParam("sort") String order) throws Exception {
        List<ProductDTO> response = this.categoryService.getCategoryProduct(product,order);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO dto) throws Exception {
        return ResponseEntity.ok(this.categoryService.createCategory(dto));
    }
}
