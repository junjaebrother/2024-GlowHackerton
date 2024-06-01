package com.GlowhackerTon.demo.dto.response.ResponseShop;

import com.GlowhackerTon.demo.dto.response.ResponseGet.ResponseGetComment;
import com.GlowhackerTon.demo.dto.response.ResponseGet.ResponseGetMenu;

import java.util.List;

public class ResponseShopDetails {
    private List<ResponseGetMenu> menus;
    private List<ResponseGetComment> comments;

    public ResponseShopDetails(List<ResponseGetMenu> menus, List<ResponseGetComment> comments) {
        this.menus = menus;
        this.comments = comments;
    }
}
