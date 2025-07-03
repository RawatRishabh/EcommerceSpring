package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dto.CategoryDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.io.IOException;


public interface ICategoryGateway
{
   List<CategoryDTO> getAllCategory() throws IOException;
}
