package library.mvc;

import library.service.AuthorService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @author Azarenko Anton
 */
@ContextConfiguration({
        "classpath:context.xml",
        "classpath:mvc.xml"
})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class WebTest {

    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;


    AuthorService service;

    public void setService(AuthorService service) {
        this.service = service;
    }

    @PostConstruct
    void postConctruct() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


}