package com.GlowhackerTon.demo.controller.shop;

import com.GlowhackerTon.demo.dto.request.RequestAll.RequestAllShop;
import com.GlowhackerTon.demo.dto.request.RequestNewShop.RequestAddNewMenu;
import com.GlowhackerTon.demo.dto.request.RequestNewShop.RequestAddNewShop;
import com.GlowhackerTon.demo.dto.request.RequestPostComment;
import com.GlowhackerTon.demo.dto.request.RequestShop.RequestShopDetails;
import com.GlowhackerTon.demo.dto.request.RequestShop.RequestSummerizedShop;
import com.GlowhackerTon.demo.dto.response.ResponseShop.ResponseShopDetails;
import com.GlowhackerTon.demo.dto.response.ResponseShop.ResponseSummerizedShop;
import com.GlowhackerTon.demo.dto.response.ResponseAllShop;
import com.GlowhackerTon.demo.service.shop.ShopService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/shop/all")
    public List<ResponseAllShop> getAllMarket(@RequestBody RequestAllShop request){
        return shopService.getAllShop(request);
     }

    @GetMapping("/shop/select") // 점포 리스트 받아오기
    public List<ResponseAllShop> getSelectMarket(@RequestBody RequestAllShop request) {
        return shopService.getSelectShop(request);
    }

    @GetMapping("/shop/summerzied")
    public ResponseSummerizedShop getShopSummerized(@RequestBody RequestSummerizedShop request){
        return shopService.getSummerizedShop(request);
    }

    @GetMapping("/shop/detail")
    public ResponseShopDetails getShopDetails(@RequestBody RequestShopDetails request){
        return shopService.getShopDetails(request);
    }

    @PostMapping("/shop/comment")
    public void postShopComment(@RequestBody RequestPostComment request){
        shopService.postShopComment(request);
    }

    @PostMapping("/shop/new")
    public void addNewShop(@RequestBody RequestAddNewShop request){
        shopService.addNewShop(request);
    }

    @PostMapping("/shop/new/menu")
    public void addNewMenu(@RequestBody RequestAddNewMenu request){
        shopService.addNewMenu(request);
    }
}
