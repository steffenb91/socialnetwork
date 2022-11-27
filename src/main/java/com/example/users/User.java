package com.example.users;

import java.util.ArrayList;
import java.util.List;

import com.example.feed.Feed;
import com.example.notifications.Notification;
import com.example.notifications.NotificationFactory;
import com.example.postings.Post;

public class User {

    private String username;
    private Feed feed = new Feed();
    private List<User> followers = new ArrayList<>();
    private Notifications notifications = new Notifications();

    public User(String username) {
        this.username = username;
    }

    /**
     * Nutzer postet einen neuen Post.
     * 
     * @param post, der gepostet werden soll
     */
    public void postNew(Post post) {
        feed.addPost(post);
        followers.forEach(follower -> follower.addToFeed(post));
    }

    public void follow(User user) {
        user.addFollower(this);
    }

    public void readNotifications() {
        notifications.readAll();
    }

    /**
     * Benachrichtigt den Nutzer über einen neuen Post.
     */
    public void notify(Notification notification) {
        notifications.add(notification);
    }

    private void addFollower(User user) {
        followers.add(user);
    }

    private void addToFeed(Post post) {
        feed.addPost(post);
        notify(NotificationFactory.createNewPostCreatedNotification(post, this));
    }

    /**
     * @return den aktuellen Feed des Nutzers
     */
    public Feed getFeed() {
        return feed;
    }

    /**
     * @return ungelesene Benachrichtigungen
     */
    public List<Notification> getUnreadNotifications() {
        return notifications.getUnreadNotifications();
    }

    @Override
    public String toString() {
        return username;
    }

}
