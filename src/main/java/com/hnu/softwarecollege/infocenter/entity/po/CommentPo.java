package com.hnu.softwarecollege.infocenter.entity.po;

import java.util.Date;

public class CommentPo {
    private Long commentId;

    private Long resKey;

    private Long userKey;

    private Long commentChildId;

    private Long commentParentId;

    private Date commentDate;

    private String commentIsanonymity;

    private String commentContext;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getResKey() {
        return resKey;
    }

    public void setResKey(Long resKey) {
        this.resKey = resKey;
    }

    public Long getUserKey() {
        return userKey;
    }

    public void setUserKey(Long userKey) {
        this.userKey = userKey;
    }

    public Long getCommentChildId() {
        return commentChildId;
    }

    public void setCommentChildId(Long commentChildId) {
        this.commentChildId = commentChildId;
    }

    public Long getCommentParentId() {
        return commentParentId;
    }

    public void setCommentParentId(Long commentParentId) {
        this.commentParentId = commentParentId;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentIsanonymity() {
        return commentIsanonymity;
    }

    public void setCommentIsanonymity(String commentIsanonymity) {
        this.commentIsanonymity = commentIsanonymity == null ? null : commentIsanonymity.trim();
    }

    public String getCommentContext() {
        return commentContext;
    }

    public void setCommentContext(String commentContext) {
        this.commentContext = commentContext == null ? null : commentContext.trim();
    }
}