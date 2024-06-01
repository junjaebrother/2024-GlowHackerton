package com.GlowhackerTon.demo.domain.shop;

import com.GlowhackerTon.demo.domain.comment.Comment;
import com.GlowhackerTon.demo.domain.market.Market;
import com.GlowhackerTon.demo.domain.menu.Menu;
import com.GlowhackerTon.demo.dto.request.RequestNewShop.RequestAddNewMenu;
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
    private String workingTime;

    @Column(nullable = false, length = 20)
    private String address;

    @Column(nullable = false, length = 200)
    private String briefExplanation;

    @ManyToOne
    private Market market;

    private Long starPoint; // 별점 -> 프론트에서 알아서 정수 값 받아와서 ID개수만큼 나눠서 별점 표시할 것
    private Long x;
    private Long y;
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

    public Long getStarPoint() {
        return starPoint;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getWorkingTime() {
        return workingTime;
    }

    public String getAddress() {
        return address;
    }

    public String getBriefExplanation() {
        return briefExplanation;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public Shop(Market market, String name, String telephone, String address, String workingTime, String briefExplanation, Long x, Long y, Integer type) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("%s점포는 존재하지 않습니다."));
        }
        this.market = market;
        this.name = name;
        this.telephone = telephone;
        this.workingTime = workingTime;
        this.briefExplanation = briefExplanation;
        this.address = address;
        this.x = x;
        this.y = y;
        this.starPoint = 0L;
        this.type = type;
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
        Integer sum = 0;
        for(Comment c:comment){
            sum += c.getStarPoint();
        }
        this.starPoint = (long) (sum / (comment.size()));
    }

    public void saveMenu(RequestAddNewMenu request){
        this.menu.add(new Menu(this, request.getName(), request.getPrice()));
    }
}

