package library.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import library.entity.Book;

public interface BookService extends BaseService<Long, Book>{

	List<Book> getBooks();

    List<Book> getBooksByTitle(String title);

    List<Book> getBooksByAuthor(Long id);

    List<Book> getBooksByPublisher(String name);

    String upload(MultipartFile file, String path);
}
