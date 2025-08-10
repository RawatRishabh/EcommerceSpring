package com.example.EcommerceSpring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity
{
    @Column(nullable = false, unique = true)
    private String name;

    // This does not mean, that we are storing product table in the list of product in the category table
    // Telling JPA, the relationship is already owned by the product entity, so just read from there.
    // The owning side is the entity that contains the foreign key and is responsible for updating the relationship in the database.
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
