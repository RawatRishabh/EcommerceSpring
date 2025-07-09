package com.example.EcommerceSpring.mappers;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.FakeStoreCategoryResponseDTO;

import java.util.List;

public class GetAllCategoriesMapper
{
    public static FakeStoreCategoryResponseDTO tofakeStoreCategoryResponseDTO()
    {
        return null;
    }

    public static List<CategoryDTO> tocategoryDTOList(FakeStoreCategoryResponseDTO responseDTO)
    {
        return responseDTO.getCategories().stream()
                .map(category -> CategoryDTO.builder()
                        .name(category)
                        .build())
                .toList();
    }
}
