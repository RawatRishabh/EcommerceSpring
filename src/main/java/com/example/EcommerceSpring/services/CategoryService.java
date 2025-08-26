package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.CategoryAllProductDTO;
import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.exception.CategoryNotFoundException;
import com.example.EcommerceSpring.mappers.CategoryMapper;
import com.example.EcommerceSpring.mappers.ProductMapper;
import com.example.EcommerceSpring.repository.CategoryRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class CategoryService implements ICategoryService{

    private final CategoryRepository repo1;

    public CategoryService(CategoryRepository repo1) {
        this.repo1 = repo1;
    }

    @Override
    public List<CategoryDTO> getAllCategory() throws IOException { // need implement
        List<Category> categories = repo1.getallCategory();
        return categories.stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
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

    @Override
    public CategoryDTO findByName(String name)  {
        Category category = repo1.findByName(name).orElseThrow(()->new CategoryNotFoundException("Category "+name+" not found in DB!"));
        return CategoryMapper.toDto(category);
    }

    @Override
    public CategoryAllProductDTO getAllProductInCategory(long id) {
        Category category = repo1.findById(id).orElseThrow(()->new CategoryNotFoundException("Category "+id+" not found in DB!"));
        return CategoryMapper.to_DTO(category);
    }


}
