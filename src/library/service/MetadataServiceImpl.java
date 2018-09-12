package library.service;

import library.dao.MetadataDao;
import library.entity.Metadata;
import org.springframework.stereotype.Service;

@Service
public class MetadataServiceImpl implements MetadataService {

    private MetadataDao mdao;

    public void setMdao(MetadataDao mdao) {
        this.mdao = mdao;
    }

    @Override
    public Metadata getById(Long id) {
        return mdao.read(id);
    }

    @Override
    public Long save(Metadata o) {
        Long id = null;
        if (o.getId() == null) {
            id = mdao.create(o);
        } else {
            mdao.update(o);
            id = o.getId();
        }
        return id;
    }

    @Override
    public void delete(Long id) {
        mdao.delete(id);
    }

}
