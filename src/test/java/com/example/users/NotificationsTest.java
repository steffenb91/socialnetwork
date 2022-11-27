package com.example.users;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import com.example.UserTestbuilder;
import com.example.postings.Post;
import com.example.postings.PostFactory;

class NotificationsTest {

    @Test
    void shouldReadNotifications(){
        User user = UserTestbuilder.newUser().build();
        User influencer = UserTestbuilder.newUser().build();
        user.follow(influencer);
        Post influencerPost = PostFactory.makeNewPost(influencer, "Hello World!");
        influencer.postNew(influencerPost);
        assertThat(user.getUnreadNotifications().size(), is(1));
        Post comment = PostFactory.makeNewPost(user, "Hello!");
        influencerPost.addComment(comment);
        influencerPost.likedBy(user);
        assertThat(user.getUnreadNotifications().size(), is(3));
        user.readNotifications();
        assertThat(user.getUnreadNotifications().size(), is(0));
    }
}
