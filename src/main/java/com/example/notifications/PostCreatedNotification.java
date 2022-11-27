package com.example.notifications;

import com.example.postings.Post;
import com.example.users.User;

class PostCreatedNotification extends Notification {

    private Post post;
    private Post comment;

    PostCreatedNotification(Post post, Post comment, User user) {
        super();
        this.post = post;
        this.comment = comment;
    }

    PostCreatedNotification(Post post, User user) {
        super();
        this.post = post;
    }

    @Override
    public void read() {
        System.out.println(getMessage());
    }

    private String getMessage() {
        if(comment == null) {
            return String.format("%s: Nutzer %s hat etwas neues gepostet!", creationDate, post.getOriginalPoster());
        } else {
            return String.format("%s: Nutzer %s hat den Post '%s' kommentiert!", creationDate, comment.getOriginalPoster(), post.getContent());
        }
    }
    
}
