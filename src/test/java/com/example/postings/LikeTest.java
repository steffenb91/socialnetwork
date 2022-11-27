package com.example.postings;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import com.example.UserTestbuilder;
import com.example.users.User;

public class LikeTest {
    

    @Test
    void shouldLike() {
        User user = UserTestbuilder.newUser().build();
        User influencer = UserTestbuilder.newUser().build();
        Post newPost = PostFactory.makeNewPost(influencer, "Insert some controversial statement...");
        newPost.likedBy(user);
        assertThat(newPost.getLikes().size(), is(1));
    }
}
