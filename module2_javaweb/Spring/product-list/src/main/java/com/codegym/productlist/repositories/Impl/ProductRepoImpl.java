package com.codegym.productlist.repositories.Impl;

import com.codegym.productlist.models.Product;
import com.codegym.productlist.repositories.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepoImpl implements ProductRepository {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone 11", 2000.0, "Apple"));
        products.put(2, new Product(2, "Iphone 8", 1500.0, "Apple"));
        products.put(3, new Product(3, "Iphone 6", 1000.0, "Apple"));
        products.put(4, new Product(4, "Samsung galaxy a7", 700.0, "Samsung"));
        products.put(5, new Product(5, "Xiaomi redmi a7", 5000.0, "Xiaomi"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void deleteById(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        Set<Integer> keyList = products.keySet();
        for(Integer key:keyList){
            if(products.get(key).getName().equals(name)){
                productList.add(products.get(key));
            }
        }
        return productList;
    }
}
