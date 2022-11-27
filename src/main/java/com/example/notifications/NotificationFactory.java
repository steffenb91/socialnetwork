package com.example.notifications;

import com.example.postings.Post;
import com.example.users.User;

public class NotificationFactory {
    
    public static Notification createNewPostLikedNotification(Post post, User user){
        return new PostLikedNotification(post, user);
    }

    public static Notification createNewCommentCreatedNotification(Post post, Post comment, User user) {
        return new PostCreatedNotification(post, comment, user);
    }

    public static Notification createNewPostCreatedNotification(Post post, User poster) {
        return new PostCreatedNotification(post, poster);
    }
}
