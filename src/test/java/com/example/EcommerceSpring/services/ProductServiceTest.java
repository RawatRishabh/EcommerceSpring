package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.entity.Product;
import com.example.EcommerceSpring.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest
{
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductService productService;
    private Category category;
    private Product product1;
    private ProductDTO productDTO;
    @BeforeEach
    void setUp()
    {
        product1 = new Product();
        product1.setBrand("Adidas");
        product1.setImage("ArcticSoul.png");
        product1.setModel("AS-0");
        product1.setPrice(2340);
        product1.setTitle("NewMe");
        product1.setId(1);
        productDTO = new ProductDTO();
        category = new Category();
        category.setName("Footwear");
        category.setId(1);
        product1.setCategory(category);
    }

    @Test
    @DisplayName("Should return product by ID")
    void getProductByID_shouldReturnProduct()
    {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product1));
        productDTO = productService.getProductByID(1L);
        assertEquals(1,productDTO.getId());
        assertEquals("Adidas",productDTO.getBrand());
    }
}
