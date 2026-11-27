package com.example.trai_ga_bt6;

public class Album {
    private int id;
    private String imageUrl;
    private String date;
    private String description;

    public Album(int id, String imageUrl, String date, String description) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.date = date;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}