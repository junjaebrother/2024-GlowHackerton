package com.GlowhackerTon.demo.dto.request.RequestNewShop;

import com.GlowhackerTon.demo.dto.request.RequestGetComment;

import java.util.List;

public class RequestAddNewShop {

    private Integer type;
    private String name;
    private String address;
    private String telephone;
    private String workingTime;

    public Integer getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getWorkingTime() {
        return workingTime;
    }


}