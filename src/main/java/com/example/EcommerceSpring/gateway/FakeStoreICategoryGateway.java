package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.FakeStoreCategoryResponseDTO;
import com.example.EcommerceSpring.gateway.api.FakeCategoryApi;
import com.example.EcommerceSpring.mappers.GetAllCategoriesMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreICategoryGateway implements ICategoryGateway
{

    private final FakeCategoryApi fakeCategoryApi;

    public FakeStoreICategoryGateway(FakeCategoryApi fakeCategoryApi) {
        this.fakeCategoryApi = fakeCategoryApi;
    }

    @Override
    public List<CategoryDTO> getAllCategory() throws IOException {
        // 1. Make the HTTP request to the FakeStore API to fetch all categories
        FakeStoreCategoryResponseDTO response = this.fakeCategoryApi.getAllFakeCategories().execute().body();

        // 2. Checking that response is not null and thrown an exception, if it is
        if(response==null)
        {
            throw new IOException("Failed to fetch categories from FakeStore API");
        }

        // 3. Map the response to a list of CategoryDTO object
        return GetAllCategoriesMapper.tocategoryDTOList(response);
    }
}
