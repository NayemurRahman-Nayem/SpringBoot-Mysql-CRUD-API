package com.springrest.springrest.controller;
import com.springrest.springrest.Dao.BookDao;
import com.springrest.springrest.entities.BookEntity;
import com.springrest.springrest.services.BookService;
import com.springrest.springrest.services.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@RestController
@RequestMapping(value="/api/v1/book")
public class BookController {

    // get the courses
    @Autowired                   // Dependency Injection
    private BookServiceImpl bookService;


    // Get all the course
    @RequestMapping(path="/books",method= RequestMethod.GET)
    public List<BookEntity> getBooks() {
        List<BookEntity> list =  bookService.getBooks() ;
        List<BookEntity> tar = new ArrayList<>() ;
        for(BookEntity book:list) {
            BookEntity bookDto = book ;
            tar.add(bookDto) ;
        }
        return tar ;
    }

    // Get the course where id = courseid ;
    @RequestMapping(path="/{isbn}",method=RequestMethod.GET)
    public BookEntity getBook(@PathVariable(value = "isbn") String isbn) {
        return this.bookService.getBook(Long.parseLong(isbn)) ;
    }

    @RequestMapping(path="/books",method=RequestMethod.POST)
    public BookEntity AddBook(@RequestBody BookEntity book) {
        return this.bookService.addBook(book) ;
    }

    //update the title of the couse having id = id ;
    @RequestMapping(path="/update",method=RequestMethod.PUT)
    public BookEntity UpdateBook(@RequestBody BookEntity book ) {
        return this.bookService.updateBook(book,book.getIsbn()) ;
    }

    // Delete the couse having id = id ;
    @RequestMapping(path="/{isbn}",method=RequestMethod.DELETE)
    public void DeleteBook(@PathVariable(value="isbn") String isbn) {
        this.bookService.deleteBook(Long.parseLong(isbn));
    }
}
