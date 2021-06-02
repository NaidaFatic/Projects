package com.example.lab6_intent;

public class News {
    private String  title,  shortDescription;
    private int imageUri;

    public News(String title, String shortDescription, int imageUri) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.imageUri = imageUri;
    }

    public String getTitle() {
        return title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public int getImageUri() {
        return imageUri;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setImageUri(int imageUri) {
        this.imageUri = imageUri;
    }
}
