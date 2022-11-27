package com.example.postings;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import com.example.UserTestbuilder;
import com.example.users.User;

class PostingsTest {
    
    @Test
    void shouldComment() {
        User user = UserTestbuilder.newUser().build();
        User influencer = UserTestbuilder.newUser().build();
        user.follow(influencer);
        Post post = PostFactory.makeNewPost(influencer, "Test post");
        influencer.postNew(post);
        Post comment = PostFactory.makeNewPost(user, "Test works!");
        post.addComment(comment);
        assertThat(post.getComments().contains(comment), is(true));
    }

    @Test
    void shouldSubscribeToComments(){
        User user = UserTestbuilder.newUser().build();
        User otherUser = UserTestbuilder.newUser().build();
        User influencer = UserTestbuilder.newUser().build();
        user.follow(influencer);
        otherUser.follow(influencer);
        Post post = PostFactory.makeNewPost(influencer, "Test post");
        influencer.postNew(post);
        Post comment = PostFactory.makeNewPost(user, "Comment on test post");
        post.addComment(comment);
        Post anotherComment = PostFactory.makeNewPost(otherUser, "another comment");
        post.addComment(anotherComment);
    }
}
