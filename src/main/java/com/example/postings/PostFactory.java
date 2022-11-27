package com.example.postings;

import com.example.users.User;

public class PostFactory {
    
    public static Post makeNewPost(User user, String text){
        return new Post(user, new Content(text));
    }
}
