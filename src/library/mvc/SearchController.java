package library.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import library.service.SearchService;

@Controller
public class SearchController {

    @Autowired
    private SearchService srv;

    @Autowired
    private Form form;

    @PostMapping("search.html")
    public String search(@RequestParam("book") String book, @RequestParam("author") String author) {
        form.setBook(book);
        form.setAuthor(author);
        return "redirect:search.html";
    }

    @GetMapping("search.html")
    public String search(Model model) {
        model.addAttribute("books", srv.search(form.getBook(), form.getAuthor()));
        return "books";
    }

    @Component
    @Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public static class Form {
        private String book;

        private String author;

        public String getBook() {
            return book;
        }

        public void setBook(String book) {
            this.book = book;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
    }
}
