package service.Impl;

import module.Product;
import service.ProductService;

import java.util.*;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer,Product> productMap;
    static {
        productMap = new HashMap<>();
        productMap.put(1,new Product(1,"iPhone 11",1000.0,"Apple"));
        productMap.put(2,new Product(2,"Samsung Galaxy S9",2000.0,"SamSung"));
        productMap.put(3,new Product(3,"SamSung Galaxy A7 plus",250.5,"SamSung"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<Product>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(),product);
    }

//    @Override
//    public void update(Product product) {
//
//    }

    @Override
    public void delete(int id) {
        productMap.remove(id);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        Set<Integer> set = productMap.keySet();
        for(Integer key:set){
            if(productMap.get(key).getName().equals(name)){
                products.add(productMap.get(key));
            }
        }
        return products;
    }
}
