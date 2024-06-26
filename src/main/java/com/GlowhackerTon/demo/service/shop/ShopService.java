package com.GlowhackerTon.demo.service.shop;

import com.GlowhackerTon.demo.domain.comment.Comment;
import com.GlowhackerTon.demo.domain.comment.CommentRepository;
import com.GlowhackerTon.demo.domain.market.Market;
import com.GlowhackerTon.demo.domain.market.MarketRepository;
import com.GlowhackerTon.demo.domain.menu.MenuRepository;
import com.GlowhackerTon.demo.domain.shop.Shop;
import com.GlowhackerTon.demo.domain.shop.ShopRepository;
import com.GlowhackerTon.demo.dto.request.RequestAll.RequestAllShop;
import com.GlowhackerTon.demo.dto.request.RequestNewShop.RequestAddNewMenu;
import com.GlowhackerTon.demo.dto.request.RequestNewShop.RequestAddNewShop;
import com.GlowhackerTon.demo.dto.request.RequestPostComment;
import com.GlowhackerTon.demo.dto.request.RequestShop.RequestShopDetails;
import com.GlowhackerTon.demo.dto.request.RequestShop.RequestSummerizedShop;
import com.GlowhackerTon.demo.dto.response.ResponseAllShop;
import com.GlowhackerTon.demo.dto.response.ResponseShop.ResponseShopDetails;
import com.GlowhackerTon.demo.dto.response.ResponseShop.ResponseSummerizedShop;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopService {
    private final ShopRepository shopRepository;
    private final MenuRepository menuRepository;
    private final CommentRepository commentRepository;
    private final MarketRepository marketRepository;

    public ShopService(ShopRepository shopRepository, MenuRepository menuRepository, CommentRepository commentRepository, MarketRepository marketRepository) {
        this.shopRepository = shopRepository;
        this.menuRepository = menuRepository;
        this.commentRepository = commentRepository;
        this.marketRepository = marketRepository;
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

    @Transactional
    public ResponseShopDetails getShopDetails(RequestShopDetails request){
        Shop shop = shopRepository.findByName(request.getName());
        return new ResponseShopDetails(shop.getMenu(), shop.getComment());
    }

    @Transactional
    public void postShopComment(RequestPostComment request){
        Shop shop = shopRepository.findByName(request.getName());
        shop.saveComment(request);
    }

    @Transactional
    public void addNewShop(RequestAddNewShop request) {
        Market market = marketRepository.findByName(request.getMarketName());
        shopRepository.save(new Shop(market, request.getName(), request.getTelephone(), request.getAddress(),
                request.getWorkingTime(), request.getBreif(), request.getX(), request.getY(), request.getType()));
    }

    @Transactional
    public void addNewMenu(RequestAddNewMenu request){
        Shop shop = shopRepository.findByName(request.getMarketName());
        shop.saveMenu(request);
    }
}
