package library.dao;

import library.entity.Metadata;

public interface MetadataDao extends CrudDao<Long, Metadata> {

    Metadata findByBookId(Long id);

}
