package com.authorapp.controller;

import com.authorapp.model.BookModel;
import com.authorapp.model.domain.Author;
import com.authorapp.model.domain.Book;
import com.authorapp.model.service.api.AuthorService;
import com.authorapp.model.service.api.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthorController {

    @Inject
    private AuthorService authorService;

    @Inject
    private BookService bookService;

    @RequestMapping("/")
    public ModelAndView hello() {
        ModelAndView model = new ModelAndView("hello");
        return model;
    }

    @RequestMapping("/authors")
    public ModelAndView authors() {
        ModelAndView model = new ModelAndView("authors");

        model.addObject("authorList", authorService.findAll());

        return model;
    }

    @RequestMapping("/authors/{id}")
    public ModelAndView authorInfo(@PathVariable Long id) {
        ModelAndView model = new ModelAndView("authorInfo");

        model.addObject("author", authorService.findAuthorById(id));

        return model;
    }





    // NEED TO REFACTOR to REST
    @RequestMapping(value = "/authors/{id}/delete", method = RequestMethod.GET)
    public ModelAndView deleteAuthor(@PathVariable Long id) {
        ModelAndView model = new ModelAndView("authors");
        Author author = authorService.findAuthorById(id);

        if (author != null) {
            authorService.delete(author);
        }

        model.addObject("authorList", authorService.findAll());

        return model;
    }

    //          implement validation here
    @RequestMapping(value = "/authors/{id}", method = RequestMethod.POST)
    public String authorEdit(@PathVariable Long id, @ModelAttribute("author") @Valid Author author,
                                   BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "authorInfo";
        }
        authorService.update(author);

        Author loadedAuthor = authorService.findAuthorById(id);
        model.addAttribute("author", loadedAuthor);

        return "authorInfo";
    }

    @RequestMapping(value = "/authors/new")
    public ModelAndView addNewAuthor() {
        Author author = new Author();
        authorService.save(author);

        ModelAndView model = new ModelAndView("authorInfo");

        model.addObject("author", author);
        return model;
    }
}
