package com.chao.bishe.domain;

import java.util.Date;
import java.util.Objects;

public class CommentTest {
    private int commentId;
    private String orderID;
    private String openid;
    private String name;
    private String avatarUrl;//头像
    private String content;
    private Date createTime;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentTest that = (CommentTest) o;
        return commentId == that.commentId &&
                Objects.equals(orderID, that.orderID) &&
                Objects.equals(openid, that.openid) &&
                Objects.equals(name, that.name) &&
                Objects.equals(avatarUrl, that.avatarUrl) &&
                Objects.equals(content, that.content) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(commentId, orderID, openid, name, avatarUrl, content, createTime);
    }
}
