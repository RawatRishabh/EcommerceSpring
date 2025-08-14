package com.example.EcommerceSpring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private String brand;
    private boolean popular;

    @ManyToOne(fetch = FetchType.EAGER)
    // @JoinColumn ke through tu specify karta hai ki Product table me FK ka naam kya hoga.
    @JoinColumn(name = "categoryId",nullable = false) // category can exists without product, but product does not exists without category. depedency high on category.
    /*
     nullable = false ka effect sirf tab hota hai jab tum product table me record insert/update karte ho, table khali hone par koi constraint trigger nahi hota.
     */
    private Category category;
}
