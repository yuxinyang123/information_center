package com.hnu.softwarecollege.infocenter.entity.vo;

import javax.validation.constraints.NotEmpty;

/**
 * @program: infocenter
 * @description:
 * @author: yu
 * @create: 2018-11-21 17:40
 **/
public class CommentForm {
    @NotEmpty
    private String commentContext;

    public String getCommentContext() {
        return commentContext;
    }

    public void setCommentContext(String commentContext) {
        this.commentContext = commentContext;
    }
}
