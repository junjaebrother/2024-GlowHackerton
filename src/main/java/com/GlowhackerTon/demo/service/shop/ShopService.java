package com.GlowhackerTon.demo.service.shop;

import com.GlowhackerTon.demo.domain.shop.ShopRepository;
import com.GlowhackerTon.demo.dto.request.RequestAllShop;
import com.GlowhackerTon.demo.dto.response.ResponseAllShop;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopService {
    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository){
        this.shopRepository = shopRepository;
    }

    @Transactional
    public List<ResponseAllShop> getShop(RequestAllShop request) {
        return shopRepository.findAllByType(request.getType()).stream()
                .map(ResponseAllShop::new)
                .collect(Collectors.toList());
    }

}
