package library.service;

import library.dao.MetadataDao;
import library.entity.Metadata;

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
    public void save(Metadata o) {
	if (o.getId() == null) {
	    mdao.create(o);
	} else {
	    mdao.update(o);
	}

    }

    @Override
    public void delete(Long id) {
	mdao.delete(id);
    }

}
