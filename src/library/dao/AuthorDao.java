package library.dao;

import java.util.List;

import library.entity.Author;

public interface AuthorDao extends CrudDao<Long, Author> {

    List<Author> readAll();

    List<Author> find(String name);
}
