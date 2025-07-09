package com.example.EcommerceSpring.gateway;
import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.FakeStoreCategoryResponseDTO;
import com.example.EcommerceSpring.mappers.GetAllCategoriesMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Component("fakeStoreRest")
public class FakeStoreCategoryRestTemplateGateway implements ICategoryGateway
{
    private final RestTemplateBuilder restTemplateBuilder;

    public FakeStoreCategoryRestTemplateGateway(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }


    @Override
    public List<CategoryDTO> getAllCategory() throws IOException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "https://fakestoreapi.in/api/products/category";
        ResponseEntity<FakeStoreCategoryResponseDTO> response = restTemplate.getForEntity(url,FakeStoreCategoryResponseDTO.class);
        if(response.getBody() == null)
        {
            throw new IOException("Failed to fetch categories from FakeStoreAPI");
        }
        return GetAllCategoriesMapper.tocategoryDTOList(response.getBody());
    }
}
