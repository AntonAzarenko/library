package library.service;

import library.entity.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static library.AuthorTestData.*;

@ContextConfiguration({
        "classpath:context.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class AuthorServiceImplTest {

    @Autowired
    private  AuthorService service;

    @Test
    public void getById() {
        Author author = service.getById(AUTHOR1_ID);
        assertMatch(author,AUTHOR1);

    }

    @Test
    public void getAllAuthors() {
        List<Author> authors = service.getAll();
        assertMatch(authors,AUTHOR1,AUTHOR2,AUTHOR3);
    }

    @Test
    public void save() {
    }

    @Test
    public void getAuthorByName() {
        List<Author> authors = service.getByName(AUTHOR1_NAME);
        assertMatch(authors,AUTHOR1);
    }

    @Test
    public void delete() {
        service.delete(AUTHOR3_ID);
        assertMatch(service.getAll(),AUTHOR1,AUTHOR2);
    }
}