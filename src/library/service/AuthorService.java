package library.service;

import library.entity.Author;

import java.util.List;

public interface AuthorService extends BaseService<Long, Author>{

    Author getAuthor(Long id);

    List<Author> getAllAuthors();

    List<Author> getAuthorByName(String name);
}
