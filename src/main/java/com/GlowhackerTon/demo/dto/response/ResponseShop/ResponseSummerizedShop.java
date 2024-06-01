package com.GlowhackerTon.demo.dto.response.ResponseShop;

import com.GlowhackerTon.demo.domain.shop.Shop;

public class ResponseSummerizedShop {
    private String name;
    private String address;
    private String telephone;
    private String workingHour;
    private String briefExplanation;
    private Long star;

    public ResponseSummerizedShop(Shop shop) {
        this.name = shop.getName();
        this.address = shop.getAddress();
        this.telephone = shop.getTelephone();
        this.workingHour = shop.getWorkingHour();
        this.briefExplanation = shop.getBriefExplanation();
        this.star = shop.getStar();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getWorkingHour() {
        return workingHour;
    }

    public String getBriefExplanation() {
        return briefExplanation;
    }

    public Long getStar() {
        return star;
    }
}
