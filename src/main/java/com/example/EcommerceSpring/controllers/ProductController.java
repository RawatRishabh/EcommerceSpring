package com.example.EcommerceSpring.controllers;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.dto.ProductsDTO;
import com.example.EcommerceSpring.services.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController
{
    private final IProductService iProductService;

    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductByID(@PathVariable long id) throws Exception
    {
        ProductDTO productDTO = this.iProductService.getProductByID(id);
        return ResponseEntity.ok(productDTO);
    }

    @GetMapping
    public ResponseEntity<List<ProductsDTO>> getAllProducts() throws Exception {
       List<ProductsDTO> productsDTOS = this.iProductService.getAllProducts();
       return ResponseEntity.ok(productsDTOS);
    }

    @GetMapping(params = {"page"})
    public ResponseEntity<List<ProductsDTO>> getProducts_page(@RequestParam("page") long num) throws Exception {
        List<ProductsDTO> productsPage = this.iProductService.getProducts_page(num);
        return ResponseEntity.ok(productsPage);
    }

}
