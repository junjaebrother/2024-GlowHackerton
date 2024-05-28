package com.GlowhackerTon.demo.domain.shop;

import com.GlowhackerTon.demo.domain.comment.Comment;
import com.GlowhackerTon.demo.domain.menu.Menu;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // primary키를 자동생성
    private Long id = null;

    @Column(nullable = false, length = 20) // 시장 이름 길이제한 20자
    private String name;
    private Long star; // 별점 -> 프론트에서 알아서 정수 값 받아와서 ID개수만큼 나눠서 별점 표시할 것
    private int x;
    private int y;
    private Integer type;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comment = new ArrayList<>();

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Menu> menu = new ArrayList<>();

    protected Shop() {}


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getStar() {
        return star;
    }

    public Shop(String name, Long star) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("%s점포는 존재하지 않습니다."));
        }
        this.name = name;
        this.star = star;
    }
}

