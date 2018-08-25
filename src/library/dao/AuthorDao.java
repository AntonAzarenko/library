package library.dao;

import java.util.List;

import library.entity.Author;

public interface AuthorDao extends CrudDao<Long, Author> {

    List<Author> findByName(String name);
}
