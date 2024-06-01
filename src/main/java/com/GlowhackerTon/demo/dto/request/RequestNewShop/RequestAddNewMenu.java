package com.GlowhackerTon.demo.dto.request.RequestNewShop;

public class RequestAddNewMenu {
    private String name;
    private int price;

    public RequestAddNewMenu(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
