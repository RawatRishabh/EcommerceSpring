package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.ProductDTO;


import java.util.List;
import java.io.IOException;


public interface ICategoryGateway
{
   List<CategoryDTO> getAllCategory() throws IOException;
   List<ProductDTO> getCategoryProduct(String product,String order) throws Exception;
}

