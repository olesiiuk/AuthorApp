package com.authorapp.model.service.impl;

import com.authorapp.model.domain.Book;
import com.authorapp.model.repository.BookRepository;
import com.authorapp.model.service.api.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service("bookService")
@Transactional(propagation = Propagation.REQUIRED)
public class BookServiceImpl implements BookService {

    @Inject
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findOne(id);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> findByAuthorId(Long id) {
        return bookRepository.findBooksByAid(id);
    }

    @Override
    public List<Book> updateBooks(List<Book> books) {
        return bookRepository.save(books);
    }
}
