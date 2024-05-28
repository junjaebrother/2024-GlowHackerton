package com.GlowhackerTon.demo.domain.market;

import com.GlowhackerTon.demo.domain.shop.Shop;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, length = 20) // 시장 이름 길이제한 20자
    private String name;
    private String information; // 시장 설명

    @OneToMany(mappedBy = "market", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Shop> shop = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInformation() {
        return information;
    }
}
