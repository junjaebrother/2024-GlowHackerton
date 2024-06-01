package com.GlowhackerTon.demo.dto.response.ResponseGet;

import com.GlowhackerTon.demo.domain.menu.Menu;

public class ResponseGetMenu {
    private String name;
    private Integer price;

    public ResponseGetMenu(Menu menu) {
        this.name = menu.getName();
        this.price = menu.getPrice();
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
