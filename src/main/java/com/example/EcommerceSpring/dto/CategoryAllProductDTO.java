package com.example.EcommerceSpring.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryAllProductDTO
{
    private String name;
    private long id;
    private List<ProductDTO> productDTOlist;
}
