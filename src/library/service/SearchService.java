package library.service;

import java.util.List;

import library.entity.Book;

public interface SearchService {

    List<Book> search(String book, String author, String publisher);
}
