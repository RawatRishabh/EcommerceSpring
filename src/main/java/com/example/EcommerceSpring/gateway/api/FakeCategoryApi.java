package com.example.EcommerceSpring.gateway.api;

import com.example.EcommerceSpring.dto.FakeStoreCategoryResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;


public interface FakeCategoryApi
{
    @GET("products/category")
    Call<FakeStoreCategoryResponseDTO> getAllFakeCategories();
}
