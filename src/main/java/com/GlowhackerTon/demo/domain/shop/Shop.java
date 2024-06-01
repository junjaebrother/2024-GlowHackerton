package com.GlowhackerTon.demo.domain.shop;

import com.GlowhackerTon.demo.domain.comment.Comment;
import com.GlowhackerTon.demo.domain.menu.Menu;
import com.GlowhackerTon.demo.dto.request.RequestPostComment;
import com.GlowhackerTon.demo.dto.response.ResponseGet.ResponseGetComment;
import com.GlowhackerTon.demo.dto.response.ResponseGet.ResponseGetMenu;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // primary키를 자동생성
    private Long id = null;

    @Column(nullable = false, length = 20) // 시장 이름 길이제한 20자
    private String name;

    @Column(nullable = false, length = 20)
    private String telephone;

    @Column(nullable = false, length = 40)
    private String workingHour;

    @Column(nullable = false, length = 20)
    private String address;

    @Column(nullable = false, length = 20)
    private String briefExplanation;

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

    public String getTelephone() {
        return telephone;
    }

    public String getWorkingHour() {
        return workingHour;
    }

    public String getAddress() {
        return address;
    }

    public String getBriefExplanation() {
        return briefExplanation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Shop(String name, Long star) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("%s점포는 존재하지 않습니다."));
        }
        this.name = name;
        this.star = star;
    }

    public List<ResponseGetMenu> getMenu(){
        return this.menu.stream()
                .map(ResponseGetMenu::new)
                .collect(Collectors.toList());
    }

    public List<ResponseGetComment> getComment(){
        return this.comment.stream()
                .map(ResponseGetComment::new)
                .collect(Collectors.toList());
    }

    public void saveComment(RequestPostComment request){
        this.comment.add(new Comment(this, request.getComment(), request.getStarPoint()));

    }
}

