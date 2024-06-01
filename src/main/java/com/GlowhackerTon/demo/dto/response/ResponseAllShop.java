package com.GlowhackerTon.demo.dto.response;

import com.GlowhackerTon.demo.domain.shop.Shop;

public class ResponseAllShop {
    private String name;

    public ResponseAllShop(Shop market){
        this.name = market.getName();
    }
}
