package library.dao;

import java.util.List;

import library.entity.Publisher;

public interface PublisherDao extends CrudDao<Long, Publisher> {
	
	Publisher findByName(String name);
	
	List<Publisher> findByAuthorId(Long id);
}
