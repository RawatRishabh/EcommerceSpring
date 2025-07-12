package com.example.EcommerceSpring.configuration;

import com.example.EcommerceSpring.gateway.api.FakeCategoryApi;
import com.example.EcommerceSpring.gateway.api.FakeProductApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig
{
    @Value("${base.url}")
    private String url;

    @Bean
    public Retrofit retrofit()
    {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create()) // Invoke the Gson
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
