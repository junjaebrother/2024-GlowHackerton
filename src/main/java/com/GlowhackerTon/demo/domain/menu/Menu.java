package com.GlowhackerTon.demo.domain.menu;

import com.GlowhackerTon.demo.domain.shop.Shop;
import jakarta.persistence.*;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @ManyToOne
    private Shop shop;

    @Column(nullable = false, length = 20)
    private String name;
    private Integer price;

    protected Menu() {}

    public Menu(Shop shop, String name, Integer price) {
        this.shop = shop;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
