package com.springrest.springrest.services;
import com.springrest.springrest.Dao.BookDao;
import com.springrest.springrest.entities.BookEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.awt.print.Book;
import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDao bookDao ;

//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;

    @Override
    @Cacheable(value = "books")
    public List<BookEntity> getBooks() {
        System.out.println("Get the books from DB");
        return bookDao.findAll();
    }

    @Override
    public BookEntity getBook(long isbn) {
        Optional<BookEntity> book = bookDao.findById(isbn) ;
        return book.orElse(null);
    }

    @Override
    @CachePut(value = "books")
    public List<BookEntity> addBook(BookEntity book) {
        bookDao.save(book) ;
        List<BookEntity> books = bookDao.findAll();
        return books ;
    }

    @Override
    public BookEntity updateBook(BookEntity book , long isbn) {
        Optional<BookEntity> optionalBook = bookDao.findById(isbn);
        if (optionalBook.isPresent()) {
            BookEntity existingBook = optionalBook.get();
            existingBook.setAuthor(book.getAuthor());
            existingBook.setBook_name(book.getBook_name());
            existingBook.setBook_type(book.getBook_type());
            existingBook.setPrice(book.getPrice());
            // The @PreUpdate method will automatically update the `updated` field
            return bookDao.save(existingBook);  // Save the updated entity
        } else {
            // Handle the case when the book is not found
            throw new RuntimeException("Book with ISBN " + isbn + " not found.");
        }
    }

    @Override
    public void deleteBook(long isbn) {
        BookEntity book = bookDao.getOne(isbn) ;
        bookDao.delete(book);
    }
}
