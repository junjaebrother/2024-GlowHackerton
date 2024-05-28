package com.GlowhackerTon.demo.dto.response;

import com.GlowhackerTon.demo.domain.market.Market;

public class ResponseAllMarket {
    private String name;

    public ResponseAllMarket(Market market) {
        this.name = market.getName();
    }
}
