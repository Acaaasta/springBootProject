package com.sprBootProject.springBootProject.services;

import com.sprBootProject.springBootProject.entities.Product;
import com.sprBootProject.springBootProject.repositories.ProductsRepozitiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    private ProductsRepozitiry productsRepozitiry;

    @Autowired
    public void setProductsRepozitiry(ProductsRepozitiry productsRepozitiry) {
        this.productsRepozitiry = productsRepozitiry;
    }

    public List<Product> getAllProducts(){

        return (List<Product>)productsRepozitiry.findAll();

    }


}

