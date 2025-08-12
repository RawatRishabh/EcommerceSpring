package com.example.EcommerceSpring.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryDTO
{
    private String image;
    private String color;
    private int price;
    private long id;
    private String description;
    private int discount;
    private String model;
    private String title;
    private String brand;
    private boolean popular;
    private CategoryDTO categoryDTO;
}
