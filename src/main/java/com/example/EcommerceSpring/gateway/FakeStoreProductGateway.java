package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dto.*;
import com.example.EcommerceSpring.gateway.api.FakeProductApi;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.List;

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

    @Override
    public List<ProductDTO> getAllProducts() throws Exception {
       FakeAllProductResponseDTO response = this.fakeProductApi.getAllProducts().execute().body();
        if(response==null)
        {
            throw new IOException("Failed to fetch products from FakeStore API");
        }
        return response.getProducts();
    }

    @Override
    public List<ProductDTO> getProducts_page(long num) throws Exception {
        FakeAllProductResponseDTO response = this.fakeProductApi.getProducts_page(num).execute().body();
        if(response==null)
        {
            throw new IOException("Failed to fetch products from page in FakeStore API");
        }
        return response.getProducts();

    }
}
