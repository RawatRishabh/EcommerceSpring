package com.example.EcommerceSpring.repository;

import com.example.EcommerceSpring.entity.Category;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long>
{
    Optional<Category> findByName(String name);

    @Query(value="select * from category", nativeQuery = true)
    List<Category> getallCategory();
}
