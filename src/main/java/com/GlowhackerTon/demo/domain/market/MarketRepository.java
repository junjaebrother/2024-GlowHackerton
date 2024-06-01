package com.GlowhackerTon.demo.domain.market;

import com.GlowhackerTon.demo.dto.response.ResponseMarket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<Market, Long> {
    Market findByName(String name);
}
