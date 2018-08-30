package library.service;

import library.dao.AuthorDao;
import library.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    public void setAuthorDao(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public Author getById(Long id) {
        return authorDao.read(id);
    }

    @Override
    public List<Author> getAll() {
        return authorDao.readAll();
    }

    @Override
    public Author getByName(String name) {
        return authorDao.findByName(name);
    }

    @Override
    public void save(Author author) {
        if (author.getId() == null) {
            authorDao.create(author);
        } else {
            authorDao.update(author);
        }
    }

    @Override
    public void delete(Long id) {
        authorDao.delete(id);
    }

    @Override
    public List<Author> getListAuthorsById(List<Long> ids) {
        return authorDao.getListAuthorsById(ids);
    }
}
