package library.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import library.service.BookService;

@Controller
public class MainController {

   /* @Autowired
    private BookService srv;

    @RequestMapping("index.html")
    public String index(final Model model) {
        model.addAttribute("books", srv.getBooks(""));
        return "index";
    }

    @RequestMapping("booksByAuthors.html")
    public String booksByAuthor(@RequestParam("id") final Long id, final Model model) {
        model.addAttribute("listBooks", srv.getBooksByAuthor(id));
        return "booksByAuthors";
    }*/
}
