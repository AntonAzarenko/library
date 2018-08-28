package library.service;

import java.util.List;

import library.dao.BookDao;
import library.entity.Book;

public class SearchServiceImpl implements SearchService {

    private BookDao dao;

    public void setDao(BookDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Book> search(final String book, final String author) {
        return dao.find(book, author);
    }
}
