package com.sprBootProject.springBootProject.controllers;

import com.sprBootProject.springBootProject.entities.Product;
import com.sprBootProject.springBootProject.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/")
    public String showHomePage(Model model, @RequestParam(value = "min", required = false) Double min,
                               @RequestParam(value = "max", required = false) Double max){

        Page<Product> page = productsService.getProductsByCost(PageRequest.of(0, 5), min, max);
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("page", page);
        model.addAttribute("products", productsService.getAllProducts());
        return "index";
    }

    @GetMapping("/info")
    public String showInfoPage(Model model){
        return "info";
    }

    @GetMapping("/product/add")
    public String addProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "add-product";
    }

    @PostMapping("/product/add")
    public String addProduct(Model model, @ModelAttribute("product") Product product) {
        productsService.saveOrUpdate(product);
        return "redirect:/";
    }

}
