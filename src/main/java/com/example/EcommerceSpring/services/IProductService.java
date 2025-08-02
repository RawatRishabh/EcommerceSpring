package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.ProductDTO;

import java.util.List;

public interface IProductService
{
    ProductDTO getProductByID(Long id) throws Exception;
    List<ProductDTO> getAllProducts() throws Exception;
    List<ProductDTO> getProducts_page(long num) throws Exception;
    ProductDTO createProduct (ProductDTO dto) throws Exception;
}

