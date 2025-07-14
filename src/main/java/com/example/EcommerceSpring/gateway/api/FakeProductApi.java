package com.example.EcommerceSpring.gateway.api;

import com.example.EcommerceSpring.dto.FakeAllProductResponseDTO;
import com.example.EcommerceSpring.dto.FakeStoreCategoryResponseDTO;
import com.example.EcommerceSpring.dto.FakeStoreProductResponse;
import com.example.EcommerceSpring.dto.ProductsDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FakeProductApi
{
    @GET("products/{id}")
    Call<FakeStoreProductResponse> getProductById(@Path("id") long id) throws Exception;

    @GET("products")
    Call<FakeAllProductResponseDTO>  getAllProducts() throws Exception;

    @GET("products")
    Call<FakeAllProductResponseDTO> getProducts_page(@Query("page") long num) throws Exception;
}
