package com.example.EcommerceSpring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FakeStoreProductResponse{
	private ProductDTO product;
	private String message;
	private String status;
}