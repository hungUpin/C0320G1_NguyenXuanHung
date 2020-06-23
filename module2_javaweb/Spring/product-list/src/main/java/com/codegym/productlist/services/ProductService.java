package com.codegym.productlist.services;

import com.codegym.productlist.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProduct();
    void addNewProduct(Product product);
    Product findProductById( int id);
    void deleteProductById( int id);
    List<Product> findProductByName(String name);
}
