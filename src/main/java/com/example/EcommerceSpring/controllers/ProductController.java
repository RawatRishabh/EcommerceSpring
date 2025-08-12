package com.example.EcommerceSpring.controllers;

import com.example.EcommerceSpring.dto.ProductCategoryDTO;
import com.example.EcommerceSpring.dto.ProductDTO;
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
    public ResponseEntity<List<ProductDTO>> getAllProducts() throws Exception {
       List<ProductDTO> productDTOS = this.iProductService.getAllProducts();
       return ResponseEntity.ok(productDTOS);
    }

    @GetMapping(params = {"page"})
    public ResponseEntity<List<ProductDTO>> getProducts_page(@RequestParam("page") long num) throws Exception {
        List<ProductDTO> productsPage = this.iProductService.getProducts_page(num);
        return ResponseEntity.ok(productsPage);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO dto) throws Exception {
         return ResponseEntity.ok(iProductService.createProduct(dto));
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<ProductCategoryDTO> getProductWithCategory(@PathVariable long id) throws Exception
    {
        return ResponseEntity.ok(this.iProductService.getProductWithCategory(id));
    }
}
