package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.ProductsDTO;


import java.util.List;
import java.io.IOException;


public interface ICategoryGateway
{
   List<CategoryDTO> getAllCategory() throws IOException;
   List<ProductsDTO> getCategoryProduct(String product, String order) throws Exception;
}

