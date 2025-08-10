package com.example.EcommerceSpring.mappers;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.FakeStoreCategoryResponseDTO;
import com.example.EcommerceSpring.entity.Category;

import java.util.List;

public class GetAllCategoriesMapper
{

    public static List<CategoryDTO> tocategoryDTOList(FakeStoreCategoryResponseDTO responseDTO)
    {
        return responseDTO.getCategories().stream()
                .map(category -> CategoryDTO.builder()
                        .name(category)
                        .build())
                .toList();
    }


}
