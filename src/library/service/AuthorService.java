package library.service;

import library.entity.Author;

import java.util.List;

public interface AuthorService extends BaseService<Long, Author>{

    List<Author> getAll();

    Author getByName(String name);

    List<Author> getListAuthorsById(List<Long> ids);
}
