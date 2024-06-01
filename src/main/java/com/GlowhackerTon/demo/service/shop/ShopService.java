package com.GlowhackerTon.demo.service.shop;

import com.GlowhackerTon.demo.domain.shop.Shop;
import com.GlowhackerTon.demo.domain.shop.ShopRepository;
import com.GlowhackerTon.demo.dto.request.RequestAll.RequestAllShop;
import com.GlowhackerTon.demo.dto.request.RequestNewShop.RequestAddNewShop;
import com.GlowhackerTon.demo.dto.request.RequestShop.RequestSummerizedShop;
import com.GlowhackerTon.demo.dto.response.ResponseAllShop;
import com.GlowhackerTon.demo.dto.response.ResponseShop.ResponseSummerizedShop;
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
    public List<ResponseAllShop> getSelectShop(RequestAllShop request) {
        return shopRepository.findAllByType(request.getType()).stream()
                .map(ResponseAllShop::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ResponseAllShop> getAllShop(RequestAllShop request) {
        return shopRepository.findAll().stream()
                .map(ResponseAllShop::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public ResponseSummerizedShop getSummerizedShop(RequestSummerizedShop request){
        Shop shop =  shopRepository.findByName(request.getName());
        return new ResponseSummerizedShop(shop);
    }
    /*
    @Transactional
    public void addNewShop(RequestAddNewShop request) {
        Shop shop = shopRepository.save(new Shop())
    }
    */
}
