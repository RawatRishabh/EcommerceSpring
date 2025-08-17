package com.example.EcommerceSpring.mappers;

import com.example.EcommerceSpring.dto.CategoryAllProductDTO;
import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.entity.Category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper
{
    public static CategoryDTO toDto(Category category)
    {
        return CategoryDTO.builder()
                .name(category.getName())
                .id(category.getId())
                .build();
    }

    public static Category toEntity(CategoryDTO dto)
    {
        return Category.builder()
                .name(dto.getName())
                .build();
    }

    public static CategoryAllProductDTO to_DTO(Category category)
    {
        return  CategoryAllProductDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .productDTOlist(category.getProducts().stream().map(ProductMapper::toDTO).collect(Collectors.toList()))
                .build();
    }

}
