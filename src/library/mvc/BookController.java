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

    @Autowired
    private PublisherService pService;

    @Autowired
    private AuthorService aServise;

    /**
     * This method gets all books and show their on the index.jsp
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "index.html", method = RequestMethod.GET)
    public String getAll(final Model model) {
        model.addAttribute("books", srv.getBooks());
        return "index";
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
        return "index";
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
        return "index";
    }


    /**
     * This method save new book, or update book and redirect to index.jsp
     *
     * @param bookTo
     * @return
     */
    @PostMapping(value = "booksave.html")
    public String save(BookTo bookTo) {
        Book book = bookTo.asBook();
        book.setAuthor(aServise.getListAuthorsById(bookTo.getAuthors()));
        book.setPublisher(pService.getById(bookTo.getPublisherId()));
        srv.save(book);
        return "redirect:index.html";
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
        return "index";
    }

    /**
     * This method removes book by id and redirect to index
     *
     * @param id
     * @return
     */
    @PostMapping(value = "remove.html")
    public String delete(@RequestParam("id") final Long id) {
        srv.delete(id);
        return "redirect:index.html";
    }

    /**
     * This method gets book and put in model and redirect to edit page editbook.jsp
     *
     * @param model
     * @return
     */
    @GetMapping(value = "edit.html")
    public String edit(@RequestParam(required = false) @PathVariable("id") final Long id, final Model model) {
        if (id == null) {
            model.addAttribute("publishers", pService.getAll());
            model.addAttribute("authors", aServise.getAll());
        } else {
            model.addAttribute("book", srv.getById(id));
            model.addAttribute("publishers", pService.getAll());
            model.addAttribute("authors", aServise.getAll());
        }
        return "addedit";
    }

    @GetMapping(value = "addAuthor.html")
    public String addAuthor(@RequestParam("name") String name, final Model model) {
        model.addAttribute("addAuthors", aServise.getByName(name));
        model.addAttribute("publishers", pService.getAll());
        model.addAttribute("authors", aServise.getAll());
        return "addedit";
    }
}
