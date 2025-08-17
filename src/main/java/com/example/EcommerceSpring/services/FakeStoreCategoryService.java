package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.CategoryAllProductDTO;
import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.gateway.ICategoryGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryService implements ICategoryService
{

    private final ICategoryGateway categoryGateway;

    public FakeStoreCategoryService(@Qualifier("fakeStoreRest") ICategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public List<CategoryDTO> getAllCategory() throws IOException {
        return categoryGateway.getAllCategory();
    }

    @Override
    public List<ProductDTO> getCategoryProduct(String product, String order) throws Exception {
        return this.categoryGateway.getCategoryProduct(product,order);
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO dto) throws Exception {
        return null;
    }

    @Override
    public CategoryDTO findByName(String name) throws Exception {
        return null;
    }

    @Override
    public CategoryAllProductDTO getAllProductInCategory(long id) {
        return null;
    }
}
