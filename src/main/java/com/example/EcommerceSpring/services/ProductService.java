package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.entity.Product;
import com.example.EcommerceSpring.mappers.ProductMapper;
import com.example.EcommerceSpring.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class ProductService implements IProductService{

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public ProductDTO getProductByID(Long id) throws Exception {
        return repo.findById(id)
                .map(ProductMapper::toDTO)
                .orElseThrow(() -> new Exception("Product not found!"));
      /* .map() aur .orElseThrow() tumhare ProductMapper se nahi aaye —
        Ye Optional<Product> class ke methods hain jo repo.findById(id) return karta hai.
        Iska kaam hai: agar product mila to usko ProductDTO me convert karo, warna exception throw karo.
        Optional is part of Java, tumhe banane ki zarurat nahi hoti
        Optional is a built-in class in Java 8+
        Package: java.util.Optional
        Agar tum Java 8 ya uske baad ka version use kar rahe ho (which Spring Boot karta hi hai), to tum automatically Optional use kar sakte ho. */
    }

    @Override
    public List<ProductDTO> getAllProducts() throws Exception {
        return List.of();
    }

    @Override
    public List<ProductDTO> getProducts_page(long num) throws Exception {
        return List.of();
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) throws Exception {
        Product saved = repo.save(ProductMapper.toEntity(dto)); // Updates Entity Object return
        return  ProductMapper.toDTO(saved);
        /*
        * repo.save() sirf new row (data entry) add karta hai ya existing row ko update karta hai.
          Ye table kabhi bhi nahi banata — table to app ke start hone par Hibernate banata hai (agar config allow kare).
        */
    }
}
