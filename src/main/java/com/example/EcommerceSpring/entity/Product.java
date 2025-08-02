package com.example.EcommerceSpring.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product extends BaseEntity
{
    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private String model;
    private String title;
    private String category;
    private String brand;
    private boolean popular;
}
