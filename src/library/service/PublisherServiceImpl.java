package library.service;

import java.util.List;

import library.dao.PublisherDao;
import library.entity.Publisher;

public class PublisherServiceImpl implements PublisherService {

    private PublisherDao dao;

    public void setPublisherDao(final PublisherDao dao) {
        this.dao = dao;
    }

    @Override
    public Publisher getById(final Long id) {
        return dao.read(id);
    }

    @Override
    public Long save(Publisher o) {
        Long id = null;
        if (o.getId() == null) {
            id = dao.create(o);
        } else {
            dao.update(o);
            id = o.getId();
        }
        return id;
    }

    @Override
    public void delete(final Long id) {
        dao.delete(id);
    }

    @Override
    public Publisher getByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public List<Publisher> getByAuthorId(Long id) {
        return dao.findByAuthorId(id);
    }

    @Override
    public List<Publisher> getAll() {
        return dao.readAll();
    }
}
