package com.authorapp.controller;

import com.authorapp.model.BookModel;
import com.authorapp.model.domain.Author;
import com.authorapp.model.domain.Book;
import com.authorapp.model.service.api.AuthorService;
import com.authorapp.model.service.api.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/authors")
public class BookController {

    @Inject
    private AuthorService authorService;

    @Inject
    private BookService bookService;

    @RequestMapping("/{id}/books")
    public ModelAndView authorsBooks(@PathVariable Long id) {
        ModelAndView model = new ModelAndView("authorsBooks");

        BookModel bookModel = new BookModel();
        bookModel.setBooks(bookService.findByAuthorId(id));

        model.addObject("book", new Book());
        model.addObject("bookModel", bookModel);
        model.addObject("author", authorService.findAuthorById(id));

        return model;
    }

    @RequestMapping(value = "/{id}/books", method = RequestMethod.POST)
    public ModelAndView updateBooks(@PathVariable Long id, @ModelAttribute BookModel bookModel) {

        ModelAndView model = new ModelAndView("authorsBooks");

        Author author = authorService.findAuthorById(id);

        for (Book b : bookModel.getBooks()) {
            b.setAuthor(author);
            bookService.save(b);
        }

        List<Book> books = bookService.findByAuthorId(id);

        bookModel.setBooks(books);

//        model.addObject("bookModel", bookModel);
//        model.addObject("author", authorService.findAuthorById(id));
//
//        return model;
        return new ModelAndView("redirect:/authors/" + id + "/books");
    }

    @RequestMapping(value = "/{id}/books/save", method = RequestMethod.POST)
    public ModelAndView saveBook(@PathVariable Long id,  @ModelAttribute Book book) {
        Author author = authorService.findAuthorById(id);
        book.setAuthor(author);
        bookService.save(book);

        return new ModelAndView("redirect:/authors/" + id + "/books");
    }
}
