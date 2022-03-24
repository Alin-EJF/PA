package com.items;

import com.Item;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Book extends Item {

    private String author;
    private final int year;

    public Book(@JsonProperty("id")String id,
                @JsonProperty("year")int year) {
        super(id);
        this.year = year;
    }

    @JsonCreator
    public Book(@JsonProperty("id")String id,
                @JsonProperty("title")String title,
                @JsonProperty("location")String location,
                @JsonProperty("year")int year,
                @JsonProperty("author")String author) {
        super(id,title,location);
        this.year = year;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + this.getId() + '\'' +
                ", title='" + this.getTitle() + '\'' +
                ", location='" + this.getLocation() + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
