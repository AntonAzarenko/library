package library.service;

import library.dao.MetadataDao;
import library.entity.Metadata;
import org.springframework.stereotype.Service;

public class MetadataServiceImpl implements MetadataService {

    private MetadataDao metadataDao;

    public void setMetadataDao(MetadataDao metadataDao) {
        this.metadataDao = metadataDao;
    }

    @Override
    public Metadata getById(Long id) {
        return metadataDao.read(id);
    }

    @Override
    public Long save(Metadata o) {
        Long id = null;
        if (o.getId() == null) {
            id = metadataDao.create(o);
        } else {
            metadataDao.update(o);
            id = o.getId();
        }
        return id;
    }

    @Override
    public void delete(Long id) {
        metadataDao.delete(id);
    }

}
