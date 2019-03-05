package com.sprBootProject.springBootProject.repositories;

import com.sprBootProject.springBootProject.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends CrudRepository<Product,Long> {
    Page<Product> findAllByCostBetween(Pageable pageable, double minCost, double maxCost);
    //Product findOneByTitle(String title);
}
