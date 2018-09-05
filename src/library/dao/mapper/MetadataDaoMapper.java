package library.dao.mapper;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import library.dao.MetadataDao;
import library.entity.Metadata;

public class MetadataDaoMapper extends SqlSessionDaoSupport implements MetadataDao {

    @Override
    public void create(Metadata o) {
	getSqlSession().insert("library.dao.MetadataDao.create", o);
    }

    @Override
    public Metadata read(Long id) {
	return getSqlSession().selectOne("library.dao.MetadataDao.read", id);
    }

    @Override
    public List<Metadata> readAll() {
	return getSqlSession().selectList("library.dao.MetadataDao.findAll");
    }

    @Override
    public void update(Metadata o) {
	getSqlSession().update("library.dao.MetadataDao.update", o);
    }

    @Override
    public void delete(Long id) {
	getSqlSession().delete("library.dao.MetadataDao.delete", id);

    }

    @Override
    public Metadata findByBookId(Long id) {
	return getSqlSession().selectOne("library.dao.MetadataDao.findByBookId", id);
    }

}
