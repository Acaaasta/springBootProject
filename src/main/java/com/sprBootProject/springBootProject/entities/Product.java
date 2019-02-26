package com.sprBootProject.springBootProject.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name="cost")
    private Float cost;

    @ManyToMany
    @JoinTable(
            name = "clients_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private List<Client> clients;

    public List<Client> getClients() {
        return clients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product id = " + id + ", title = " + title;
    }
}
