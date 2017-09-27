package com.authorapp.model;

import com.authorapp.model.domain.Book;

import java.util.List;

public class BookModel {
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
