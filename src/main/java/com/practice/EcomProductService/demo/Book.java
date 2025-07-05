package com.practice.EcomProductService.demo;

import jakarta.persistence.*;
import lombok.ToString;

@Entity
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String bookName;

    @ManyToOne
    @JoinColumn(name = "author_Id")
    private Author author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book(){}
    public Book(String bookName, Author author){
        this.bookName=bookName;
        this.author=author;
    }
}
