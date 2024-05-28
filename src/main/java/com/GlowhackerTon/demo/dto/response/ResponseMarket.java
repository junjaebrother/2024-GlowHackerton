package com.GlowhackerTon.demo.dto.response;

import com.GlowhackerTon.demo.domain.market.Market;

public class ResponseMarket {
    private String name;
    private String information;

    public ResponseMarket(Market market) {
        this.name = market.getName();
        this.information = market.getInformation();
    }
}
