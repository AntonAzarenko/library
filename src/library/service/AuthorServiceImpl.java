package library.service;

import library.dao.AuthorDao;
import library.entity.Author;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    private AuthorDao authorDao;

    public void setAuthorDao(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public Author getById(Long id) {
        return authorDao.read(id);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorDao.findAll();
    }

    @Override
    public void save(Author author) {
        if (author.getId() != null) {
            authorDao.create(author);
        } else {
            authorDao.update(author);
        }
    }

    @Override
    public List<Author> getAuthorByName(String name) {
        return authorDao.findByName(name);
    }

    @Override
    public void delete(Long id) {
        authorDao.delete(id);
    }
}
