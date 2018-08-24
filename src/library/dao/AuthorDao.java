package library.dao;

import java.util.List;

import library.entity.Author;

public interface AuthorDao extends CrudDao<Long, Author> {

    List<Author> findAll();

    List<Author> findByName(String name);
}
