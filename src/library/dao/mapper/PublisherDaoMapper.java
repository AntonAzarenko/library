package library.dao.mapper;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import library.dao.PublisherDao;
import library.entity.Publisher;

public class PublisherDaoMapper extends SqlSessionDaoSupport implements PublisherDao {

    @Override
    public Long create(Publisher o) {
       getSqlSession().insert("library.dao.PublisherDao.insert", o);
       return o.getId();
    }

    @Override
    public Publisher read(Long id) {
        return getSqlSession().selectOne("library.dao.PublisherDao.read", id);
    }

    @Override
    public List<Publisher> readAll() {
        return getSqlSession().selectList("library.dao.PublisherDao.readAll");
    }

    @Override
    public void update(Publisher o) {
        getSqlSession().update("library.dao.PublisherDao.update", o);
    }

    @Override
    public void delete(Long id) {
        getSqlSession().delete("library.dao.PublisherDao.delete", id);
    }

    @Override
    public Publisher findByName(String name) {
        return getSqlSession().selectOne("library.dao.PublisherDao.findByName", name);
    }

    @Override
    public List<Publisher> findByAuthorId(Long id) {
        return getSqlSession().selectList("library.dao.PublisherDao.findByAuthorId", id);
    }
}
