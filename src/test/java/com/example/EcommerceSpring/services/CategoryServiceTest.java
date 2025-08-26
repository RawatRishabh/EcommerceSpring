package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.repository.CategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

// Junit = Unit Testing framework
// Mockito = Mocking the response
@ExtendWith(MockitoExtension.class) // This annotation is used to Mockito for test class with Junit (Integrate Mockito with Junit)
public class CategoryServiceTest
{
    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @Test
    @DisplayName("Should return all categories successfully")
    void getAllCategory_shouldReturnAllCategories() throws IOException {
        // Arrange (Mocking) (fakeResponse)
        List<Category> categoryList = new ArrayList<>();
        Category category1 = new Category();
        category1.setName("Footwear");
        category1.setId(1);
        Category category2 = new Category();
        category2.setName("Clothing");
        category2.setId(2);
        categoryList.add(category1);
        categoryList.add(category2);
        when(categoryRepository.getallCategory()).thenReturn(categoryList);  // call repo method, then return categoryList
        // Act (Function call)
        List<CategoryDTO> categoryDTOList = categoryService.getAllCategory(); // Actual call to service layer method
        // Assert (Validation)
        assertEquals(2,categoryDTOList.size());
    }
}
