package library.mvc;

import org.junit.Test;


import static library.PublisherTestData.PUBLISHER_ONE;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

public class PublisherControllerTest extends WebTest {

    @Test
    public void getAll() throws Exception {
        mockMvc.perform(get("/publishers.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("publishers"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/publishers.jsp"))
                .andExpect(model().attribute("publishers", hasSize(2)))
                .andExpect(model().attribute("publishers", hasItem(
                        allOf(
                                hasProperty("id", is(1L)),
                                hasProperty("name", is(PUBLISHER_ONE.getName()))
                        )

                )));
    }

    @Test
    public void getByName() throws Exception {
        mockMvc.perform(get("/publisherByName.html" + "?name=" + PUBLISHER_ONE.getName()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("publisher"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/publisher.jsp"))
                .andExpect(model().attribute("publisher", hasSize(1)))
                .andExpect(model().attribute("publisher", hasItem(
                        allOf(
                                hasProperty("id", is(1L)),
                                hasProperty("name", is(PUBLISHER_ONE.getName()))
                        )
                )));
    }

    @Test
    public void getById() {
    }

    @Test
    public void getByAAuthorId() {
    }

    @Test
    public void save() {
    }

    @Test
    public void edit() {
    }

    @Test
    public void delete() {
    }
}