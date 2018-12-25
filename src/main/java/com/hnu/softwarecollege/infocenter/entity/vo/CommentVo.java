package com.hnu.softwarecollege.infocenter.entity.vo;

import java.util.Date;

/**
 * @ClassName CommentVo
 * @Description TODO
 * @Author liu
 * @Date 2018/12/25 16:02
 * @Version 1.0
 **/
public class CommentVo {
    private Long commentId;

    private Long resKey;

    private Long userKey;

    private Long commentChildId;

    private Long commentParentId;

    private Date commentDate;

    private String commentIsanonymity;

    private String commentContext;

    private String username;

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
        this.commentIsanonymity = commentIsanonymity;
    }

    public String getCommentContext() {
        return commentContext;
    }

    public void setCommentContext(String commentContext) {
        this.commentContext = commentContext;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "CommentVo{" +
                "commentId=" + commentId +
                ", resKey=" + resKey +
                ", userKey=" + userKey +
                ", commentChildId=" + commentChildId +
                ", commentParentId=" + commentParentId +
                ", commentDate=" + commentDate +
                ", commentIsanonymity='" + commentIsanonymity + '\'' +
                ", commentContext='" + commentContext + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
