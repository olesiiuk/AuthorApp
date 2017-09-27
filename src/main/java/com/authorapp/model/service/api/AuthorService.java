package com.authorapp.model.service.api;


import com.authorapp.model.domain.Author;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();

    Author findAuthorById(Long id);

    void save(Author author);

    void update(Author author);

    void delete(Author author);
}
