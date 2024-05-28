package com.GlowhackerTon.demo.service.market;

import com.GlowhackerTon.demo.domain.market.MarketRepository;
import com.GlowhackerTon.demo.dto.request.RequestMarket;
import com.GlowhackerTon.demo.dto.response.ResponseAllMarket;
import com.GlowhackerTon.demo.dto.response.ResponseMarket;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarketService {
    private final MarketRepository marketRepository;

    public MarketService(MarketRepository marketRepository){
        this.marketRepository = marketRepository;
    }

    @Transactional
    public List<ResponseAllMarket> getAllMarket(){
        return marketRepository.findAll().stream()
                .map(ResponseAllMarket::new)
                .collect(Collectors.toList());
    }
}
