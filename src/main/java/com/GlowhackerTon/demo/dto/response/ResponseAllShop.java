package com.GlowhackerTon.demo.dto.response;

import com.GlowhackerTon.demo.domain.shop.Shop;

public class ResponseAllShop {
    private long id;
    private String name;

    public ResponseAllShop(Shop market){
        this.id = market.getId();
        this.name = market.getName();
    }
}
