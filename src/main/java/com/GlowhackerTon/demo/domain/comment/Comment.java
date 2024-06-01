package com.GlowhackerTon.demo.domain.comment;

import com.GlowhackerTon.demo.domain.shop.Shop;
import jakarta.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    private String userComment;
    private Integer starPoint;

    @ManyToOne
    private Shop shop;

    public Comment() {

    }

    public String getUserComment() {
        return userComment;
    }

    public Comment(Shop shop, String userComment, Integer starPoint) {
        this.shop = shop;
        this.userComment = userComment;
        this.starPoint = starPoint;
    }

    public Integer getStarPoint() {
        return starPoint;
    }
}
