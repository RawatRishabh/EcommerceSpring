package com.example.EcommerceSpring.services;
import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.gateway.IProductGateway;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductService implements IProductService
{

    private final IProductGateway iProductGateway;

    public FakeStoreProductService(IProductGateway iProductGateway) {
        this.iProductGateway = iProductGateway;
    }

    @Override
    public ProductDTO getProductByID(Long id) throws Exception {
        return this.iProductGateway.getProductById(id);
    }
}
