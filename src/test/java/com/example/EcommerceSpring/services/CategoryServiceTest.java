package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.mappers.CategoryMapper;
import com.example.EcommerceSpring.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

// Junit = Unit Testing framework
// Mockito = Mocking the response
@ExtendWith(MockitoExtension.class) // This annotation is used to Mockito for test class with Junit (Integrate Mockito with Junit)
public class CategoryServiceTest
{
    //Home-work (Create category)
    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    private CategoryDTO categoryDTO = new CategoryDTO();
    private  Category category1 = new Category();
    private  Category category2 = new Category();
    private  Category category3 = new Category();
    @BeforeEach
    void setup()
    {
        categoryDTO.setName("Electronics");
        category1.setId(1);
        category1.setName("Footwear");
        category2.setId(2);
        category2.setName("Clothing");
    }
    @Test
    @DisplayName("Should return all categories successfully")
    void getAllCategory_shouldReturnAllCategories() throws IOException {
        // Arrange (Mocking) (fakeResponse)
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(category1);
        categoryList.add(category2);
        when(categoryRepository.getallCategory()).thenReturn(categoryList);  // call repo method, then return categoryList (main mocking does here)
        // Act (Function call)
        List<CategoryDTO> categoryDTOList = categoryService.getAllCategory(); // Actual call to service layer method
        // Assert (Validation)
        assertEquals(2,categoryDTOList.size());
    }

    @Test
    @DisplayName("Should return empty list when categories not exists")
    void getAllCategory_shouldReturnEmptyList() throws IOException {
        when(categoryRepository.getallCategory()).thenReturn(new ArrayList<>());
        List<CategoryDTO> categoryDTOList = categoryService.getAllCategory(); // Actual call to service layer method
        // Assert (Validation)
        assertEquals(0,categoryDTOList.size());
    }

    @Test
    @DisplayName("Should return category when is created")
    void createCategory_shouldReturnCategory() throws Exception {
       // Assert
        categoryDTO.setName("Electronics");
     category3.setName(categoryDTO.getName());
     category3.setId(3L);
     when(categoryRepository.save(any(Category.class))).thenReturn(category3);
        // Action
     CategoryDTO categoryDTO1 = categoryService.createCategory(categoryDTO);
        // Assert
     assertEquals("Electronics",categoryDTO1.getName());
     verify(categoryRepository, times(1)).save(any(Category.class));
     // verify(...) use hota hai check karne ke liye ki mock pe method call hua ya nahi.
    }
    @Test
    @DisplayName("Should return category by name")
    void findByName_shouldReturnCategory()
    {
         when(categoryRepository.findByName(anyString())).thenReturn(Optional.of(category1)); // anyString() -> any string is valid
         categoryDTO = categoryService.findByName("Footwear");
         assertEquals("Footwear", categoryDTO.getName());
    }
}
