package library.dao;

import java.util.List;

import library.entity.Author;

public interface AuthorDao extends CrudDao<Long, Author> {

    Author findByName(String name);
}
