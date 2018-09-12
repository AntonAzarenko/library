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
    public Long save(Author author) {
        Long id = null;
        if (author.getId() == null) {
            id = authorDao.create(author);
        } else {
            authorDao.update(author);
            id = author.getId();
        }
        return id;
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
