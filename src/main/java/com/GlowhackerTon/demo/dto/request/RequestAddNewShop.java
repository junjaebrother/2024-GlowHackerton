package com.GlowhackerTon.demo.dto.request;

public class RequestAddNewShop {

    private Integer type;

    private String name;

    private String address;

    private String telephone;

    private String workingTime;

    private String menu; /*** 재준상 ! 여기서 메뉴를 많이 입력받으면 Mapping된 걸 끊어야하는디
                        어캐할지...?***/

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

    public String getMenu() {
        return menu;
    }
}
