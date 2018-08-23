package library.service;

import java.util.List;

import library.entity.Book;

public interface BookService {

    Book getBook(Long id);

    List<Book> getBooks(String str);

    void save(Book book);

    List<Book> getBooksByAuthor(Long id);
}
