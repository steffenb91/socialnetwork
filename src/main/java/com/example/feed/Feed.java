package com.example.feed;

import java.util.ArrayList;
import java.util.List;

import com.example.postings.Post;

public class Feed {
    
    private List<Post> posts = new ArrayList<>();

    public void addPost(Post post) {
        posts.add(post);
    }

    public List<Post> getPosts() {
        return posts;
    }
}
