package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dto.CategoryDTO;


import java.util.List;
import java.io.IOException;


public interface ICategoryGateway
{
   List<CategoryDTO> getAllCategory() throws IOException;
}
