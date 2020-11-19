package com.domain.Post;

import com.domain.IUser.User;

import java.util.Date;

public abstract class Post {

     User poster;

     Date postTime;

     String content;

     String type;


    public Post(User poster, Date postTime, String content, String type) {
        this.poster = poster;
        this.postTime = postTime;
        this.content = content;
        this.type = type;
    }

    public User getPoster() {
        return poster;
    }

    public void setPoster(User poster) {
        this.poster = poster;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Post{" +
                "poster=" + poster +
                ", postTime=" + postTime +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
