package com.example.notifications;

import com.example.postings.Post;
import com.example.users.User;

class PostLikedNotification extends Notification {

    private Post post;
    private User likedBy;

    public PostLikedNotification(Post post, User user) {
        super();
        this.post = post;
        this.likedBy = user;
    }

    @Override
    public void read() {
        System.out.println(getMessage());
    }

    private String getMessage() {
        return String.format("%s: Post '%s' wurde gerade von Nutzer %s geliked!", creationDate, post.getContent(), likedBy);
    }

    
    
}
