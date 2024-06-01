package com.GlowhackerTon.demo.dto.response.ResponseGet;

import com.GlowhackerTon.demo.domain.comment.Comment;

public class ResponseGetComment {
    private String comment;
    private int starPoint;

    public ResponseGetComment(Comment comment) {
        this.comment = comment.getUserComment();
        this.starPoint = comment.getStarPoint();
    }
}
