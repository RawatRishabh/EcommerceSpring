package com.example.EcommerceSpring.repository;

import com.example.EcommerceSpring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>
{
    /**
     * Yeh method Spring Data JPA ke JpaRepository interface me defined hai. Iska matlab:
     * Jab tum findById() call karte ho, to tumhe direct entity nahi milti —
     * Tumhe Optional<Entity> milta hai, jo batata hai ki result ho bhi sakta hai ya nahi bhi.
     */

}
