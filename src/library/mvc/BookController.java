package library.mvc;

import library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import library.service.BookService;

import java.util.List;

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
    public String getBooksByName(@RequestParam("title")final String title, final Model model) {
        model.addAttribute("book", srv.getBooksByTitle(title));
        return "books";
    }

    /**
     * This method gets book by ID and redirect to book.jsp
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "booksByAuthors.html", method = RequestMethod.POST)
    public String getBooksByAuthor(@RequestParam("id")final  Long id,final  Model model) {
        model.addAttribute("listBooks", srv.getBooksByAuthor(id));
        return "books";
    }

    /**
     * This method save new book, or update book and redirect to index.jsp
     *
     * @param id
     * @param title
     * @param discription
     * @param authorName
     * maybe plurals if book has got a few authors
     * @param publisherName
     * @return
     */
    @PostMapping(value = "booksave.html")
    public String save(@RequestParam(required = false) @PathVariable("id") final Long id,
                       @RequestParam("title") String title,
                       @RequestParam("discription") String discription,
                       @RequestParam("name_author") List<String> authorName,
                       @RequestParam("name_publisher") String publisherName) {
        srv.save(new Book(id, title, authorName, publisherName, discription));
        return "index";
    }

    /**
     * This method gets all books and redirect to books.jsp
     *
     * @param name
     * @param model
     * @return
     */
    @GetMapping(value = "booksByPublisher.html")
    public String getBooksByPublisher(@RequestParam("publisher_name")final String name, final Model model){
       model.addAttribute("books", srv.getBooksByPublisher(name));
       return "books";
    }

    /**
     * This method removes book by id and redirect to index
     * @param id
     * @return
     */
    @PostMapping(value = "remove.html")
    public String delete(@RequestParam("id")final  Long id){
        srv.remove(id);
        return "index";
    }

    /**
     * This method gets book and put in model and redirect to edit page edit.jsp
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "edit.html")
    public String edit(@RequestParam("id") final Long id, final Model model){
        model.addAttribute("book",srv.getById(id));
        return "redirect:editbook";
    }




}
