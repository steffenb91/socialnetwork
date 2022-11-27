package com.example.users;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import com.example.UserTestbuilder;
import com.example.postings.PostFactory;

class UserTest {
 
    @Test
    void followUser() {
        User user = UserTestbuilder.newUser().build();
        User influencer = UserTestbuilder.newUser().build();
        user.follow(influencer);
        influencer.postNew(PostFactory.makeNewPost(influencer, "Test post"));
        assertThat(user.getFeed().getPosts().size(), is(1));
    }
}
