package com.domain.Post;

import com.domain.User;

import java.util.Date;

/**
 * 回帖
 */
public class ReplyPost extends Post{

    public ReplyPost(User poster, Date postTime, String content, String type) {
        super(poster, postTime, content, type);
    }
}
