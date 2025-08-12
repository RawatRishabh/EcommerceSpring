package com.example.EcommerceSpring.repository;

import com.example.EcommerceSpring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>
{
    /**
     * Yeh method Spring Data JPA ke JpaRepository interface me defined hai. Iska matlab:
     * Jab tum findById() call karte ho, to tumhe direct entity nahi milti —
     * Tumhe Optional<Entity> milta hai, jo batata hai ki result ho bhi sakta hai ya nahi bhi.
     */

    // This is a custom query method using HQL. Explicitly define the logic.
//    @Query("SELECT p from Product p WHERE p.price> :minPrice")
//    List<Product> findExpensiveProducts(@Param("minPrice") int minPrice); // Homework

    // Raw Query/Native Query
   // @Query(value="Select * from product where match(name,description) against(:keyword)",nativeQuery = true)
//    List<Product> searchFullText(@Param("keyword") String keyword); // Homework
//
//    @Query("Select p from product p where p.price > :min_price AND p.brand = :brand_name")
//    List<Product> findBybrandandPrice(@Param("min_price") int min_price, @Param("brand_name") String brand_name);

    // getAllProductsOfaCategory (Homework)

}

