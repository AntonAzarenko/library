package library.dao.mapper;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import library.dao.BookDao;
import library.entity.Book;

public class BookDaoMapper extends SqlSessionDaoSupport implements BookDao {

    @Override
    public void create(final Book o) {
    }

    @Override
    public Book read(final Long id) {
        return null;
    }

    @Override
    public void update(final Book o) {
    }

    @Override
    public void delete(final Long id) {
    }

    @Override
    public List<Book> find(final String str) {
        return getSqlSession().selectList("library.dao.BookDao.find");
    }

    @Override
    public List<Book> findByAuthorId(final Long id) {
        return getSqlSession().selectList("library.dao.BookDao.findByAuthorId", id);
    }
}
