package com.hnu.softwarecollege.infocenter.entity.vo;

import javax.validation.constraints.NotBlank;

/**
 * @program: infocenter
 * @description:
 * @author: yu
 * @create: 2018-11-21 17:40
 **/
public class CommentForm {
    @NotBlank
    private String commentContext;

    public String getCommentContext() {
        return commentContext;
    }

    public void setCommentContext(String commentContext) {
        this.commentContext = commentContext;
    }
}
