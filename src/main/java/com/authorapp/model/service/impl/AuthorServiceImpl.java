package com.authorapp.model.service.impl;

import com.authorapp.model.domain.Author;
import com.authorapp.model.repository.AuthorRepository;
import com.authorapp.model.service.api.AuthorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Olesiiuk Yaroslav aka Jay.
 */



@Service("authorService")
@Transactional(propagation = Propagation.REQUIRED)
public class AuthorServiceImpl implements AuthorService {

    @Inject
    private AuthorRepository authorRepository;


    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findAuthorById(Long id) {
        return authorRepository.findOne(id);
    }

    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void update(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void delete(Author author) {
        authorRepository.delete(author.getId());
    }
}
