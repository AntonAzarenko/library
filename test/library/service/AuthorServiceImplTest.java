package library.service;

import library.entity.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static library.AuthorTestData.*;

@ContextConfiguration({
        "classpath:context.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:initdb.sql", config = @SqlConfig(encoding = "UTF-8"))
public class AuthorServiceImplTest {

    @Autowired
    private  AuthorService service;

    @Test
    public void getById() {
        Author author = service.getById(AUTHOR1_ID);
        assertMatch(author,AUTHOR1);

    }

    @Test
    public void getByNotFoundId() throws Exception {
        Author author = service.getById(-1L);
        assertMatch(author,null);
    }

    @Test
    public void getAllAuthors() {
        List<Author> authors = service.getAll();
        assertMatch(authors,AUTHOR1,AUTHOR2,AUTHOR3);
    }

    @Test
    public void update() {
        Author author = new Author(AUTHOR3);
        author.setName("BBBBBB");
        service.save(author);
        assertMatch(service.getAll(), AUTHOR1, AUTHOR2, author);
    }

    @Test
    public void create() {
        Author author = new Author(null, "Mark Twen");
        service.save(author);
        assertMatch(service.getAll(), AUTHOR1, AUTHOR2,AUTHOR3, author);
    }

    @Test
    public void getAuthorByName() {
        Author author = service.getByName(AUTHOR1_NAME);
        assertMatch(author,AUTHOR1);
    }

    @Test
    public void getAuthorByNotFoundName() {
        Author author = service.getByName("not found name");
        assertMatch(author,null);
    }

    @Test
    public void delete() {
        service.delete(AUTHOR3_ID);
        assertMatch(service.getAll(),AUTHOR1,AUTHOR2);
    }
}