package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dto.CategoryDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component("fakeStoreRest")
public class FakeStoreCategoryRestTemplateGateway implements ICategoryGateway
{

    @Override
    public List<CategoryDTO> getAllCategory() throws IOException {
        return List.of();
    }
}
