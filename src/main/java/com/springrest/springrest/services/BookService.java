package com.springrest.springrest.services;
import com.springrest.springrest.entities.BookEntity;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public interface BookService {
    List<BookEntity> getBooks() ;
    BookEntity getBook(long isbn) ;
    List<BookEntity> addBook(BookEntity bookEntity) ;
    BookEntity updateBook(BookEntity bookEntity, long isbn) ;
    void deleteBook(long isbn) ;
}
