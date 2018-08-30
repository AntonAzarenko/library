package library.dao.mapper;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import library.dao.AuthorDao;
import library.entity.Author;

public class AuthorDaoMapper extends SqlSessionDaoSupport implements AuthorDao {

    @Override
    public void create(final Author o) {
        getSqlSession().insert("library.dao.AuthorDao.insert", o);
    }

    @Override
    public Author read(final Long id) {
        return getSqlSession().selectOne("library.dao.AuthorDao.read", id);
    }

    @Override
    public void update(final Author o) {
        getSqlSession().update("library.dao.AuthorDao.update", o);
    }

    //TODO: не работает, подумать про ограничения в базе
    @Override
    public void delete(final Long id) {
        getSqlSession().delete("library.dao.AuthorDao.delete", id);
    }

    @Override
    public Author findByName(final String name) {
        return getSqlSession().selectOne("library.dao.AuthorDao.findByName", name);
    }

    @Override
    public List<Author> readAll() {
        return getSqlSession().selectList("library.dao.AuthorDao.findAll");
    }

    @Override
    public List<Author> getListAuthorsById(List<Long> list) {
        return getSqlSession().selectList("library.dao.AuthorDao.findListById", list);
    }
}


