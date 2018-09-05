package library.service;

import library.entity.Metadata;

public interface MetadataService extends BaseService<Long, Metadata> {

    Metadata getByBookId(Long id);
}
