package com.sprBootProject.springBootProject.services;

import com.sprBootProject.springBootProject.entities.Product;
import com.sprBootProject.springBootProject.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepozitiry(ProductsRepository productsRepozitiry) {
        this.productsRepository = productsRepozitiry;
    }

    public Page<Product> getProductsByCost(Pageable pageable, Double min, Double max) {
        if (min == null) {
            min = 0.0;
        }
        if (max == null) {
            max = Double.MAX_VALUE;
        }
        return productsRepository.findAllByCostBetween(pageable, min, max);
    }

    public List<Product> getAllProducts(){

        return (List<Product>)productsRepository.findAll();

    }

    public Product saveOrUpdate(Product product) {
        return productsRepository.save(product);
    }

}

