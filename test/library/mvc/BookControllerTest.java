package library.mvc;

import org.junit.Test;


import static library.AuthorTestData.AUTHOR1;
import static library.AuthorTestData.AUTHOR1_NAME;
import static library.BookTestData.BOOK1;
import static library.BookTestData.PUBLISHER1;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

/**
 * @author Anton
 */
public class BookControllerTest extends WebTest {

    @Test
    public void getAll() throws Exception {
        mockMvc.perform(get("/index.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/index.jsp"))
                .andExpect(model().attribute("books", hasSize(3)))
                .andExpect(model().attribute("books", hasItem(
                        allOf(
                                hasProperty("id", is(1L)),
                                hasProperty("title", is(BOOK1.getTitle()))
                        )

                )));
    }



    @Test
    public void getBooksByName() throws Exception {
        mockMvc.perform(get("/booksByName.html" + "?title=" + BOOK1.getTitle()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("books"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/books.jsp"))
                .andExpect(model().attribute("book", hasSize(1)))
                .andExpect(model().attribute("book", hasItem(
                        allOf(
                                hasProperty("id", is(1L)),
                                hasProperty("title", is(BOOK1.getTitle()))
                        )
                )));
    }

    @Test
    public void getBooksByAuthor() throws Exception {
        mockMvc.perform(get("/booksByAuthors.html" + "?id=" + AUTHOR1.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("books"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/books.jsp"))
                .andExpect(model().attribute("listBooks", hasSize(2)))
                .andExpect(model().attribute("listBooks", hasItem(
                        allOf(
                                hasProperty("id", is(1L)),
                                hasProperty("title", is(BOOK1.getTitle()))
                        )
                )));
    }

    @Test
    public void save() throws Exception {
        mockMvc.perform(get("/booksave.html?title=How learn Spring&discription=&author1_id=1&author2_id=&author3_id=&name_author1=" + AUTHOR1_NAME +
                "&name_author2=&name_author3=&name_publisher=" + PUBLISHER1.getName()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getBooksByPublisher() throws Exception {
        mockMvc.perform(get("/booksByPublisher.html" + "?publisher_name=" + PUBLISHER1.getName()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("books"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/books.jsp"))
                .andExpect(model().attribute("books", hasSize(3)))
                .andExpect(model().attribute("books", hasItem(
                        allOf(
                                hasProperty("id", is(1L)),
                                hasProperty("title", is(BOOK1.getTitle()))
                        )
                )));
    }
}