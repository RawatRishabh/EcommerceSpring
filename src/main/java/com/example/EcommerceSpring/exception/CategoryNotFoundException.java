package com.example.EcommerceSpring.exception;

public class CategoryNotFoundException extends RuntimeException
{
    public CategoryNotFoundException(String message)
    {
        super(message);
    }
}
