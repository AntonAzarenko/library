package library.service;

import library.entity.Author;

import java.util.List;

public interface AuthorService {

    Author getAuthor(Long id);

    List<Author> getAllAuthors();

    void save(Author author);

    List<Author> getAuthorByName(String name);

    void delete(Long id);
}
