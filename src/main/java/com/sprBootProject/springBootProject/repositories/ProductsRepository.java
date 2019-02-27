package com.sprBootProject.springBootProject.repositories;

import com.sprBootProject.springBootProject.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends CrudRepository<Product,Long> {
}