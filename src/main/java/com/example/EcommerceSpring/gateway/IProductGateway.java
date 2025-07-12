package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.dto.ProductsDTO;

import java.util.List;

public interface IProductGateway
{
    ProductDTO getProductById(long id) throws Exception;
    List<ProductsDTO> getAllProducts() throws Exception;
}
