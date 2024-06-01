package com.GlowhackerTon.demo.dto.response;

import com.GlowhackerTon.demo.domain.market.Market;

public class ResponseMarket {
    private String name;
    private String information;
    private String address;
    private String workingTime;
    private String telephone;


    public ResponseMarket(Market market) {
        this.name = market.getName();
        this.information = market.getInformation();
        this.address = market.getTelephone();
        this.workingTime = market.getWorkingHour();
        this.telephone = market.getTelephone();
    }

    public String getName() {
        return name;
    }

    public String getInformation() {
        return information;
    }

    public String getAddress() {
        return address;
    }

    public String getWorkingTime() {
        return workingTime;
    }

    public String getTelephone() {
        return telephone;
    }
}
