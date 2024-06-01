package com.GlowhackerTon.demo.dto.request;

import com.GlowhackerTon.demo.domain.comment.Comment;

public class RequestGetComment {
    private String comment;
    private int starPoint;

    public RequestGetComment(Comment comment) {
        this.comment = comment.getUserComment();
        this.starPoint = comment.getStarPoint();
    }
}
