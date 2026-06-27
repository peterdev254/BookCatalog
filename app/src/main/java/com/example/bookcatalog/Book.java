package com.example.bookcatalog;

public class Book {

    String title;
    String author;
    String genre;
    String description;
    int imageResource;

    public Book(String title, String author,
                String genre, String description, int imageResource) {

        this.title = title;
        this.author = author;
        this.genre = genre;
        this.description = description;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource;
    }
}