package library.mvc;

import org.junit.Test;

import static library.AuthorTestData.AUTHOR1;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

/**
 * @author Anton
 */
public class AuthorControllerTest extends WebTest {

    @Test
    public void getAll() throws Exception {
        mockMvc.perform(get("/authors.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("allauthors"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/allauthors.jsp"))
                .andExpect(model().attribute("authors", hasSize(3)))
                .andExpect(model().attribute("authors", hasItem(
                        allOf(
                                hasProperty("id", is(1L)),
                                hasProperty("name", is(AUTHOR1.getName()))
                        )

                )));
    }


    @Test
    public void getByName() throws Exception {
        mockMvc.perform(get("/getAuthorByName.html" + "?name=" + AUTHOR1.getName()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("author"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/author.jsp"))
                .andExpect(model().attribute("author",hasProperty("id",is(1L))))
                .andExpect(model().attribute("author", hasProperty("name", is(AUTHOR1.getName()))));
    }

    @Test
    public void getById() throws Exception {
        mockMvc.perform(get("/getAuthorById.html" + "?id=" + AUTHOR1.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("author"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/author.jsp"))
                .andExpect(model().attribute("author", hasProperty("id", is(1L))))
                .andExpect(model().attribute("author", hasProperty("name", is(AUTHOR1.getName()))));


    }

}