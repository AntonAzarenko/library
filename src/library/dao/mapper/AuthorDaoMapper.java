package library.dao.mapper;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import library.dao.AuthorDao;
import library.entity.Author;

public class AuthorDaoMapper extends SqlSessionDaoSupport implements AuthorDao {

    @Override
    public void create(final Author o) {
        getSqlSession().insert("library.dao.AuthorDao.insert");
    }

    @Override
    public Author read(final Long id) {
        return getSqlSession().selectOne("library.dao.AuthorDao.read");
    }

    @Override
    public void update(final Author o) {
        getSqlSession().update("library.dao.AuthorDao.update");
    }

    @Override
    public void delete(final Long id) {
        getSqlSession().delete("library.dao.AuthorDao.delete");
    }

    @Override
    public List<Author> findByName(final String name) {
        return getSqlSession().selectList("library.dao.AuthorDao.findByName");
    }

    @Override
    public List<Author> reedAll() {
        return getSqlSession().selectList("library.dao.AuthorDao.findAll");
    }
}
