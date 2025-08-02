package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dto.ProductDTO;

import java.util.List;

public interface IProductGateway
{
    ProductDTO getProductById(long id) throws Exception;
    List<ProductDTO> getAllProducts() throws Exception;
    List<ProductDTO> getProducts_page(long num) throws Exception;
}
