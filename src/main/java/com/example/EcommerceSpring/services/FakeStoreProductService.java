package com.example.EcommerceSpring.services;
import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.dto.ProductsDTO;
import com.example.EcommerceSpring.gateway.IProductGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreProductService implements IProductService {

    private final IProductGateway iProductGateway;

    public FakeStoreProductService(IProductGateway iProductGateway) {
        this.iProductGateway = iProductGateway;
    }

    @Override
    public ProductDTO getProductByID(Long id) throws Exception {
        return this.iProductGateway.getProductById(id);
    }

    @Override
    public List<ProductsDTO> getAllProducts() throws Exception {
        return this.iProductGateway.getAllProducts();
    }

    @Override
    public List<ProductsDTO> getProducts_page(long num) throws Exception {
        return this.iProductGateway.getProducts_page(num);
    }

}
