package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.dto.ProductsDTO;

import java.io.IOException;
import java.util.List;

public interface IProductService
{
    ProductDTO getProductByID(Long id) throws Exception;
    List<ProductsDTO> getAllProducts() throws Exception;
}
