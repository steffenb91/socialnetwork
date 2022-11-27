package com.example.postings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.notifications.Notification;
import com.example.notifications.NotificationFactory;
import com.example.users.User;

public class Post {

    private final User originalPoster;
    private final Content content;
    private List<Post> comments = new ArrayList<>();
    private Set<User> subscribers = new HashSet<>();
    private Set<User> likes = new HashSet<>();

    Post(User originalPoster, Content content) {
        this.originalPoster = originalPoster;
        this.content = content;
        subscribe(originalPoster);
    }

    /**
     * Fügt ein neuen Kommentar zum Post hinzu.
     */
    public void addComment(Post newComment) {
        comments.add(newComment);
        subscribe(newComment.originalPoster);
        notifySubscribers(
                NotificationFactory.createNewCommentCreatedNotification(this, newComment, newComment.originalPoster));
    }

    private void notifySubscribers(Notification notification) {
        subscribers.forEach(subscriber -> subscriber.notify(notification));
    }

    private void subscribe(User user) {
        subscribers.add(user);
    }

    /**
     * @return eine Sammlung aller Kommentare des Posts.
     */
    public Collection<Post> getComments() {
        return Collections.unmodifiableCollection(comments);
    }

    public Content getContent() {
        return content;
    }

    public void likedBy(User user) {
        likes.add(user);
        subscribers.add(user);
        notifySubscribers(NotificationFactory.createNewPostLikedNotification(this, user));
    }

    public Set<User> getLikes() {
        return Collections.unmodifiableSet(likes);
    }

    public User getOriginalPoster() {
        return originalPoster;
    }
}
