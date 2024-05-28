package com.GlowhackerTon.demo.domain.shop;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    List<Shop> findAllByType(Integer type);
}
