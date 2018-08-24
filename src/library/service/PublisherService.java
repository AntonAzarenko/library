package library.service;

import java.util.List;

import library.entity.Publisher;

public interface PublisherService extends BaseService<Long, Publisher> {
	
	List<Publisher> getByName(String Name);
	
	List<Publisher> getByAuthor(String authorName);
	
	List<Publisher> getAll();
}
