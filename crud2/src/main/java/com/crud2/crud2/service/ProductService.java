package com.crud2.crud2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud2.crud2.entity.Product;
import com.crud2.crud2.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    //Post
    public Product saveProduct(Product product) {
        return repository.save(product);

    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);

    }
    //Get
    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return repository.findByName(name);
    }


    //Delete

    public String DeleteProduct(int id){
        repository.deleteById(id);
        return "Product Removed"+id;
    }
     
    //Put
    public Product updateProduct(Product product){
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }

}