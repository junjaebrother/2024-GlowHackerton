package com.GlowhackerTon.demo.controller.market;

import com.GlowhackerTon.demo.dto.response.ResponseAllMarket;
import com.GlowhackerTon.demo.service.market.MarketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MarketController {
    private final MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping("/market")
    public List<ResponseAllMarket> getAllMarket(){
        return marketService.getAllMarket();
    }
}
