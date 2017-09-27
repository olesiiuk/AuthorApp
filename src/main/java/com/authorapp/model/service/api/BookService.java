package com.authorapp.model.service.api;

import com.authorapp.model.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(Long id);

    void delete(Book book);

    void update(Book book);

    void save(Book book);

    List<Book> findByAuthorId(Long id);

    List<Book> updateBooks(List<Book> books);

}

