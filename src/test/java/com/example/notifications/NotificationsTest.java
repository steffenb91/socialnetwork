package com.example.notifications;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import com.example.postings.Post;
import com.example.postings.PostFactory;
import com.example.users.User;

class NotificationsTest {

    @Test
    void shouldGetNotifiedOnPost() {
        User user = new User("moritzbleib");
        User influencer = new User("testioid231");
        user.follow(influencer);
        Post newPost = PostFactory.makeNewPost(influencer, "Hello World!");
        Post anotherNewPost = PostFactory.makeNewPost(influencer, "Hello World again!");
        influencer.postNew(newPost);
        influencer.postNew(anotherNewPost);
        assertThat(user.getUnreadNotifications().size(), is(2));
    }

    @Test
    void shouldGetNotifiedOnComment() {
        User user = new User("mutzjemax");
        User influencer = new User("scherlpo");
        user.follow(influencer);
        Post newPost = PostFactory.makeNewPost(influencer, "Hi network!");
        influencer.postNew(newPost);
        assertThat(user.getUnreadNotifications().size(), is(1));
        Post comment = PostFactory.makeNewPost(user, "Hello socials");
        newPost.addComment(comment);
        assertThat(influencer.getUnreadNotifications().size(), is(1));
        assertThat(user.getUnreadNotifications().size(), is(2));
        User anotherUser = new User("moritzbleibtreu9182");
        Post anotherComment = PostFactory.makeNewPost(anotherUser, "Hi. This is a test");
        newPost.addComment(anotherComment);
        assertThat(influencer.getUnreadNotifications().size(), is(2));
        assertThat(user.getUnreadNotifications().size(), is(3));
    }
}
