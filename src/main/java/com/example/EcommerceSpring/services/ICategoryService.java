package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.ProductsDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public interface ICategoryService
{
    List<CategoryDTO> getAllCategory() throws IOException;
    List<ProductsDTO> getCategoryProduct(String product, String order) throws Exception;
}

