package com.GlowhackerTon.demo.dto.response;

import com.GlowhackerTon.demo.domain.market.Market;

public class ResponseMarket {
    private String name;
    private String information;
    private String address;
    private String workingHour;
    private String telephone;

    public ResponseMarket(Market market) {
        this.name = market.getName();
        this.information = market.getInformation();
        this.address = market.getTelephone();
        this.workingHour = market.getWorkingHour();
        this.telephone = market.getTelephone();
    }
}
