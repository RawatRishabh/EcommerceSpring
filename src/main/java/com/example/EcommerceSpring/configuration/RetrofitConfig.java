package com.example.EcommerceSpring.configuration;

import com.example.EcommerceSpring.gateway.api.FakeCategoryApi;
import com.example.EcommerceSpring.gateway.api.FakeProductApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig
{
    @Bean
    public Retrofit retrofit()
    {
        return new Retrofit.Builder()
                .baseUrl("https://fakestoreapi.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public FakeCategoryApi fakeCategoryApi(Retrofit retrofit)
    {
        return retrofit.create(FakeCategoryApi.class);
    }
    @Bean
    public FakeProductApi fakeProductApi(Retrofit retrofit)
    {
        return retrofit.create(FakeProductApi.class);
    }
}
