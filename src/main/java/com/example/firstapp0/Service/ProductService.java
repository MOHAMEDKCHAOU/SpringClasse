package com.example.firstapp0.Service;  // <-- Package declaration

import com.example.firstapp0.Entity.Product;
import com.example.firstapp0.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Create product
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get product by ID
    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    // Update product
    public void updateProduct(int id, Product updatedProduct) {
        Product existingProduct = getProductById(id);
        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setDescription(updatedProduct.getDescription());
            productRepository.save(existingProduct);
        }
    }

    // Delete product by ID
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
