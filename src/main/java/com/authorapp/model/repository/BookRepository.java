package com.authorapp.model.repository;

import com.authorapp.model.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Olesiiuk Yaroslav aka Jay.
 */


public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBooksByAid(Long id);

}
