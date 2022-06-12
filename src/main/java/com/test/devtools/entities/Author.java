package com.test.devtools.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Author {
    @Id
    private int authorId;
    private String authorName;
    private String language;
    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private Book book;

    public Author() {
        super();
    }

    public Author(int authorId, String name, String language, Book book) {
        this.authorId = authorId;
        this.authorName = name;
        this.language = language;
//        this.book = book;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return authorName;
    }

    public void setName(String name) {
        this.authorName = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
