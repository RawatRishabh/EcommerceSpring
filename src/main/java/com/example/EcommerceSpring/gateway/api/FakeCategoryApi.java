package com.example.EcommerceSpring.gateway.api;

import com.example.EcommerceSpring.dto.FakeAllProductResponseDTO;
import com.example.EcommerceSpring.dto.FakeStoreCategoryResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface FakeCategoryApi
{
    @GET("products/category")
    Call<FakeStoreCategoryResponseDTO> getAllFakeCategories();

    @GET("products/category")
    Call<FakeAllProductResponseDTO> getCategoryProduct(@Query("type") String product, @Query("sort") String order);

}
