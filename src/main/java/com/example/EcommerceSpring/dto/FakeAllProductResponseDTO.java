package com.example.EcommerceSpring.dto;

import java.util.List;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FakeAllProductResponseDTO{
	private String message;
	private String status;
	private List<ProductsDTO> products;
}