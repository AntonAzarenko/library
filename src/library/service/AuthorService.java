package library.service;

import library.entity.Author;

import java.util.List;

public interface AuthorService extends BaseService<Long, Author>{

    List<Author> getAllAuthors();

    List<Author> getAuthorByName(String name);
}