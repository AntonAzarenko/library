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
    public Book getBooksByTitle(String title) {
	return null;
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
	// TODO Auto-generated method stub

    }

    @Override
    public List<Book> getBooksByPublisher(String name) {
	return dao.findBooksByPublisher(name);
    }
}
