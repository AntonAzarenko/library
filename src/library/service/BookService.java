package library.service;

import java.util.List;

import library.entity.Book;

public interface BookService extends BaseService<Long, Book>{

	List<Book> getBooks();

    List<Book> getBooksByTitle(String title);

    List<Book> getBooksByAuthor(Long id);

    List<Book> getBooksByPublisher(String name);
}
