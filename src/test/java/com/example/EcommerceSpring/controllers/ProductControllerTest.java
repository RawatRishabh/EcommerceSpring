package com.example.EcommerceSpring.controllers;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.exception.GlobalExceptionHandler;
import com.example.EcommerceSpring.services.IProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
public class ProductControllerTest
{
    @Mock
    private IProductService productService;
    @InjectMocks
    private ProductController productController;
    @Mock
    private MockMvc mockMvc;
    private ProductDTO productDTO;
    @BeforeEach
    void setUp()
    {
        mockMvc = MockMvcBuilders.standaloneSetup(productController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
        productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setCategoryId(2L);
        productDTO.setBrand("Nike");
    }

    @Test
    @DisplayName("GET /api/products/1 should return product")
    void getProductByID_shouldReturnProduct() throws Exception {
        when(productService.getProductByID(anyLong())).thenReturn(productDTO);
        mockMvc.perform(get("/api/products/2").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.categoryId").value(2L))
                .andExpect(jsonPath("$.brand").value("Nike"));

    }

    @Test
    @DisplayName("Post /api/products should create product")
    void createProduct_shouldCreateProduct() throws Exception {
        ProductDTO productDTO1 = new ProductDTO();
        productDTO1.setBrand("Puma");
        productDTO1.setCategoryId(1L);
        productDTO1.setTitle("PureSoul");
        ProductDTO productDTO2 = new ProductDTO();
        productDTO2.setTitle(productDTO1.getTitle());
        productDTO2.setBrand(productDTO1.getBrand());
        productDTO2.setCategoryId(productDTO1.getCategoryId());
        productDTO2.setId(3);
        when(productService.createProduct(any(ProductDTO.class))).thenReturn(productDTO2);
        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(productDTO1)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("PureSoul"))
                .andExpect(jsonPath("$.categoryId").value(1L))
                .andExpect(jsonPath("$.brand").value("Puma"));
    }




}
