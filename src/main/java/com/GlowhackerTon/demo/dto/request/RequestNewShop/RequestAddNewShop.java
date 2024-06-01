package com.GlowhackerTon.demo.dto.request.RequestNewShop;

public class RequestAddNewShop {

    private Integer type;
    private String name;
    private String address;
    private String telephone;
    private String workingTime;
    private String Breif;
    private Long x;
    private Long y;

    public String getBreif() {
        return Breif;
    }

    public Integer getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Long getX() {
        return x;
    }

    public Long getY() {
        return y;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getWorkingTime() {
        return workingTime;
    }


}
