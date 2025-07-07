package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.FakeStoreCategoryResponseDTO;
import com.example.EcommerceSpring.dto.FakeStoreProductResponse;
import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.gateway.api.FakeProductApi;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class FakeStoreProductGateway implements IProductGateway
{

    private final FakeProductApi fakeProductApi;

    public FakeStoreProductGateway(FakeProductApi fakeProductApi) {
        this.fakeProductApi = fakeProductApi;
    }

    @Override
    public ProductDTO getProductById(long id) throws Exception {

       FakeStoreProductResponse response = this.fakeProductApi.getProductById(id).execute().body();
        if(response==null)
        {
            throw new IOException("Failed to fetch categories from FakeStore API");
        }
       return response.getProduct();
    }
}
