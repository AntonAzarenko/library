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
    }

    @Test
    public void delete() {
    }
}