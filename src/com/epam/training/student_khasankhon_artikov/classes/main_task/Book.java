package com.epam.training.student_khasankhon_artikov.classes.main_task;

import java.util.Arrays;

public class Book {
    private final int id;
    private String name;
    private String[] authors;
    private String publisher;
    private int year;
    private int pages;
    private int price;
    private String type;

    public Book(int id, String name, String[] authors, String publisher, int year, int pages, int price, String type) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
        this.price = price;
        this.type = type;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublisher() { return publisher; }

    public String getName() {
        return name;
    }

    public String[] getAuthors() { return authors; }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "<" + id +". '" + name + "', " + Arrays.toString(authors) + ", " + year + ", " + publisher +".>";
    }
}
