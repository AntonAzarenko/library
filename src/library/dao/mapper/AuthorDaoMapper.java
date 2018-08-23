package library.dao.mapper;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import library.dao.AuthorDao;
import library.entity.Author;

public class AuthorDaoMapper extends SqlSessionDaoSupport implements AuthorDao {

    @Override
    public void create(final Author o) {
    }

    @Override
    public Author read(final Long id) {
        return null;
    }

    @Override
    public void update(final Author o) {
    }

    @Override
    public void delete(final Long id) {
    }

    @Override
    public List<Author> readAll() {
        return null;
    }

    @Override
    public List<Author> find(final String name) {
        return getSqlSession().selectList("library.dao.AuthorDao.find");
    }

}
