package com.GlowhackerTon.demo.dto.response.ResponseGet;

import com.GlowhackerTon.demo.domain.comment.Comment;

public class ResponseGetComment {
    private String comment;
    private Integer starPoint;

    public ResponseGetComment(Comment comment) {
        this.comment = comment.getUserComment();
        this.starPoint = comment.getStarPoint();
    }

    public String getComment() {
        return comment;
    }

    public Integer getStarPoint() {
        return starPoint;
    }
}
