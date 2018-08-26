package library.service;

import java.util.List;

import library.dao.BookDao;
import library.entity.Book;

public class BookServiceImpl implements BookService {

    private BookDao dao;

    public void setBookDao(final BookDao dao) {
	this.dao = dao;
    }

    @Override
    public Book getById(final Long id) {
	return dao.read(id);
    }

    @Override
    public List<Book> getBooks() {
	return dao.readAll();
    }

    @Override
    public List<Book getBooksByTitle(String title) {
	return dao.find(title);
    }

    @Override
    public void save(final Book book) {
	if (book.getId() == null) {
	    dao.create(book);
	} else {
	    dao.update(book);
	}
    }

    @Override
    public List<Book> getBooksByAuthor(final Long id) {
	return dao.findByAuthorId(id);
    }

    @Override
    public void delete(Long id) {
	dao.delete(id);
    }

    @Override
    public List<Book> getBooksByPublisher(final String name) {
	return dao.findBooksByPublisher(name);
    }
}
