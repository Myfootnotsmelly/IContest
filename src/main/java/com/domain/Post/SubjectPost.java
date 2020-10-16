package com.domain.Post;

import com.domain.User;

import java.util.Date;

/**
 * 主题帖
 */
public class SubjectPost extends Post {
    private String subject;

    public SubjectPost(String subject, User poster, String content, Date postTime,String type) {
        super(poster,postTime,content,type);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
