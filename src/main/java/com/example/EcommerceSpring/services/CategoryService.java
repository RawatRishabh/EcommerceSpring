package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.mappers.CategoryMapper;
import com.example.EcommerceSpring.repository.CategoryRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Primary
public class CategoryService implements ICategoryService{

    private final CategoryRepository repo1;

    public CategoryService(CategoryRepository repo1) {
        this.repo1 = repo1;
    }

    @Override
    public List<CategoryDTO> getAllCategory() throws IOException {
        return List.of();
    }

    @Override
    public List<ProductDTO> getCategoryProduct(String product, String order) throws Exception {
        return List.of();
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO dto) throws Exception {
        Category category = repo1.save(CategoryMapper.toEntity(dto));
        return CategoryMapper.toDto(category);
    }
}
