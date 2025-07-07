package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dto.ProductDTO;

public interface IProductGateway
{
    ProductDTO getProductById(long id) throws Exception;
}
