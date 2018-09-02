package library.mvc;

import library.entity.Book;
import library.service.AuthorService;
import library.service.PublisherService;
import library.to.BookTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import library.service.BookService;


/**
 * @Author by Azarenka Anton
 */
@Controller
public class BookController {

    @Autowired
    private BookService srv;

    /**
     * This method gets all books and show their on the index.jsp
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "books.html", method = RequestMethod.GET)
    public String getAll(final Model model) {
        model.addAttribute("books", srv.getBooks());
        return "books";
    }

    /**
     * This method gets book by Title and redirect to book.jsp
     *
     * @param title
     * @param model
     * @return
     */
    @GetMapping(value = "booksByName.html")
    public String getBooksByName(@RequestParam("title") final String title, final Model model) {
        model.addAttribute("book", srv.getBooksByTitle(title));
        return "books";
    }

    /**
     * This method gets book by ID, put them to model and redirect to book.jsp
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "booksByAuthors.html", method = RequestMethod.GET)
    public String getBooksByAuthor(@RequestParam("id") final Long id, final Model model) {
        model.addAttribute("books", srv.getBooksByAuthor(id));
        return "books";
    }

    /**
     * This method gets all books, put him to model and redirect to books.jsp
     *
     * @param name
     * @param model
     * @return
     */
    @GetMapping(value = "booksByPublisher.html")
    public String getBooksByPublisher(@RequestParam("publisher_name") final String name, final Model model) {
        model.addAttribute("books", srv.getBooksByPublisher(name));
        return "books";
    }

    @GetMapping(value = "book.html")
    public String getBookById(@RequestParam("id") final Long id, final Model model) {
        model.addAttribute("book", srv.getById(id));
        return "book";
    }
}
