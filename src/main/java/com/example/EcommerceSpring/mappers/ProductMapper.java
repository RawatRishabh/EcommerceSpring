package com.example.EcommerceSpring.mappers;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.entity.Product;

public class ProductMapper
{
    public static ProductDTO toDTO(Product product)
    {
        return ProductDTO.builder()
                .image(product.getImage())
                .color(product.getColor())
                .price(product.getPrice())
                .id(product.getId())
                .description(product.getDescription())
                .model(product.getModel())
                .title(product.getTitle())
                .category(product.getCategory())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .build();
    }

    public static Product toEntity(ProductDTO productDTO)
    {
        return Product.builder()
                .image(productDTO.getImage())
                .color(productDTO.getColor())
                .price(productDTO.getPrice())
                .description(productDTO.getDescription())
                .model(productDTO.getModel())
                .title(productDTO.getTitle())
                .category(productDTO.getCategory())
                .brand(productDTO.getBrand())
                .popular(productDTO.isPopular())
                .build();
    }

}
