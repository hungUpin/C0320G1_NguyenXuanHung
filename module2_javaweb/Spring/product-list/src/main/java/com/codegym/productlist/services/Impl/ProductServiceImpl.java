package com.codegym.productlist.services.Impl;

import com.codegym.productlist.models.Product;
import com.codegym.productlist.repositories.ProductRepository;
import com.codegym.productlist.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void addNewProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findProductById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void deleteProductById(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findProductByName(String name) {
        return productRepository.findByName(name);
    }
}
