package library.dao;

import java.util.List;

import library.entity.Publisher;

public interface PublisherDao extends CrudDao<Long, Publisher> {
	
	List<Publisher> findByName(String Name);
	
	List<Publisher> findByAuthor(String authorName);
	
	List<Publisher> findAll();
}
