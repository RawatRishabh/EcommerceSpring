package com.example.EcommerceSpring.gateway.api;

import com.example.EcommerceSpring.dto.FakeStoreCategoryResponseDTO;
import com.example.EcommerceSpring.dto.FakeStoreProductResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeProductApi
{
    @GET("products/{id}")
    Call<FakeStoreProductResponse> getProductById(@Path("id") long id) throws Exception;
}
