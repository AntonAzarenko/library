package library.dao;

import java.util.List;

import library.entity.Book;

public interface BookDao extends CrudDao<Long, Book> {

    // @Select("SELECT * FROM books")
    List<Book> find(String str);

    List<Book> findByAuthorId(Long id);
    
    List<Book> findBooksByPublisher(String name);

    List<Book> find(String book, String author);
}
