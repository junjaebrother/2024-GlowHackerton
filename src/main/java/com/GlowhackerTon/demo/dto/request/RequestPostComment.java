package com.GlowhackerTon.demo.dto.request;

public class RequestPostComment {
    private String name;
    private String comment;

    private Integer starPoint;

    public String getComment() {
        return comment;
    }

    public Integer getStarPoint() {
        return starPoint;
    }

    public String getName() {
        return name;
    }
}
