package library.dao.mapper;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import library.dao.BookDao;
import library.entity.Book;

public class BookDaoMapper extends SqlSessionDaoSupport implements BookDao {

    @Override
    public void create(final Book o) {
        getSqlSession().insert("library.dao.BookDao.create", o);
        getSqlSession().insert("library.dao.BookDao.createAuthors_books", o);
    }

    @Override
    public Book read(final Long id) {
        return getSqlSession().selectOne("library.dao.BookDao.read", id);
    }

    @Override
    public void update(final Book o) {
        getSqlSession().update("library.dao.BookDao.update", o);
        getSqlSession().delete("library.dao.BookDao.deleteAuthors_books", o);
        getSqlSession().insert("library.dao.BookDao.createAuthors_books", o);
    }

    @Override
    public void delete(final Long id) {
        getSqlSession().delete("library.dao.BookDao.delete", id);
    }

    @Override
    public List<Book> find(final String str) {
        return getSqlSession().selectList("library.dao.BookDao.find", str);
    }

    @Override
    public List<Book> findByAuthorId(final Long id) {
        return getSqlSession().selectList("library.dao.BookDao.findByAuthorId", id);
    }

    @Override
    public List<Book> readAll() {
        return getSqlSession().selectList("library.dao.BookDao.findAll");
    }

    @Override
    public List<Book> findBooksByPublisher(final String name) {
        return getSqlSession().selectList("library.dao.BookDao.findBooksByPublisher", name);

    }
}
