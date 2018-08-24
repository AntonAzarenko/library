package library.service;

import java.util.List;

import library.entity.Book;

public interface BookService extends BaseService<Long, Book>{

    Book getBook(Long id);

    List<Book> getBooks();

    List<Book> getBooksByName();

    List<Book> getBooksByAuthor(Long id);
}
