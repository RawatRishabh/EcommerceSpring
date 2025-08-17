package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.CategoryAllProductDTO;
import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.ProductDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.List;

@Component
public interface ICategoryService
{
    List<CategoryDTO> getAllCategory() throws IOException;
    List<ProductDTO> getCategoryProduct(String product, String order) throws Exception;
    CategoryDTO createCategory(CategoryDTO dto) throws Exception;
    CategoryDTO findByName(String name) throws Exception;
    CategoryAllProductDTO  getAllProductInCategory(long id);
}
