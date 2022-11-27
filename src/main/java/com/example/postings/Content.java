package com.example.postings;

public class Content {

    private String text;

    Content(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }
}
