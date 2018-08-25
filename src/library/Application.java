package library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import library.entity.Book;
import library.service.BookService;

public class Application {

    private static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(final String[] args) {

	final ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
	final BookService srv = ctx.getBean(BookService.class);

	final Book book = srv.getById(1L);
	log.info("book:{}", book.getId());

	srv.getBooks().forEach(b -> log.info("id:{}", b.getId()));
    }
}
