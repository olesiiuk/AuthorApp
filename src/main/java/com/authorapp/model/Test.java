package com.authorapp.model;

import com.authorapp.configuration.DataConfig;
import com.authorapp.model.domain.Author;
import com.authorapp.model.domain.Book;
import com.authorapp.model.service.api.AuthorService;
import com.authorapp.model.service.api.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Olesiiuk Yaroslav aka Jay.
 */


public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataConfig.class);

        AuthorService authorService = (AuthorService) context.getBean("authorService");
        BookService bookService = (BookService) context.getBean("bookService");

//        Book book1 = new Book("first book");
//        Book book2 = new Book("second book");
//        Book book3 = new Book("third book");
//        Book book4 = new Book("fourth book");
//        Book book5 = new Book("fifth book");
//
//        Set<Book> books = new HashSet<>();
//        books.add(book1);
//        books.add(book2);
//        books.add(book3);
//        books.add(book4);
//        books.add(book5);
//
//        Author author = new Author("Donald", "Henders", "henders@email.com", new Date());
//        author.setBooks(books);
//
//        book1.setAuthor(author);
//        book2.setAuthor(author);
//        book3.setAuthor(author);
//        book4.setAuthor(author);
//        book5.setAuthor(author);
//
//        authorService.save(author);

//        Author author = new Author();
//        author.setId(4L);
//
//        authorService.delete(author);


//        List<Author> authorList = authorService.findAll();
//
//        for (Author author : authorList) {
//            System.out.println(author);
//        }


        List<Author> authorList = authorService.findAll();
        for (Author author : authorList) {
            System.out.println(author);
            for (Book book : author.getBooks()) {
                System.out.println(book);
            }
        }


        System.out.println("done");

    }




}
