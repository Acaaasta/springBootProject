package com.sprBootProject.springBootProject.services;

import com.sprBootProject.springBootProject.entities.Product;
import com.sprBootProject.springBootProject.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepozitiry(ProductsRepository productsRepozitiry) {
        this.productsRepository = productsRepozitiry;
    }

    public List<Product> getAllProducts(){

        return (List<Product>)productsRepository.findAll();

    }

    public Product saveOrUpdate(Product product) {
        return productsRepository.save(product);
    }

}

