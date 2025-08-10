package com.example.EcommerceSpring.repository;

import com.example.EcommerceSpring.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>
{

}
