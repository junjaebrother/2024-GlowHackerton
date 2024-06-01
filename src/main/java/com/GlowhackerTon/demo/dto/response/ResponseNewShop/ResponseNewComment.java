package com.GlowhackerTon.demo.dto.response.ResponseNewShop;

import com.GlowhackerTon.demo.domain.comment.Comment;

public class ResponseNewComment {
    private String userComment;
    private int starPoint;

    public ResponseNewComment(Comment comment) {
        this.userComment = comment.getUserComment();
        this.starPoint = comment.getStarPoint();
    }
}
