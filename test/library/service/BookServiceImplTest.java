package library.service;

import library.entity.Book;
import org.apache.ibatis.javassist.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static library.AuthorTestData.AUTHOR1;
import static library.AuthorTestData.AUTHOR1_ID;
import static library.AuthorTestData.AUTHOR1_NAME;
import static library.BookTestData.*;

/**
 * @author Anton
 */


@ContextConfiguration({
        "classpath:context.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class BookServiceImplTest {

    @Autowired
    private BookService service;
    @Test
    public void getById() {
        Book book = service.getById(BOOK_ONE_ID);
        assertMatch(book, BOOK1);
    }

    @Test
    public void getBooks() {
        List<Book> books = service.getBooks();
        assertMatch(books,BOOK1,BOOK2,BOOK3);
    }

    @Test
    public void getBooksByTitle() {
        List<Book> books = service.getBooksByTitle(BOOK_TITLE_ONE);
        assertMatch(books, BOOK1);
    }

    @Test
    public void create() {
        Book actual = new Book(null,"The Childhood", Arrays.asList(AUTHOR1),PUBLISHER2,null);
        service.save(actual);
        assertMatch(service.getBooks(),BOOK1,BOOK2,BOOK3,actual);

    }

    @Test
    public void update() {
        Book update = new Book(BOOK1);
        update.setTitle("The Little Golden Calf");
        update.setPublisher(PUBLISHER2);
        update.setAuthor(LIST_AUTHOR1);
        service.save(update);
        assertMatch(service.getById(BOOK_ONE_ID), update);
    }

    @Test
    public void getBooksByAuthor() {
        List<Book> books = service.getBooksByAuthor(AUTHOR1_ID);
        assertMatch(books, BOOK1, BOOK2);
    }

    @Test
    public void getBooksByPublisher() {
        List<Book> books = service.getBooksByPublisher("Open Book");
        assertMatch(books, BOOK1, BOOK2, BOOK3);
    }
}