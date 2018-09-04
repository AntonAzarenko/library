package library.mvc;

import library.entity.Author;
import library.entity.Book;
import library.entity.Publisher;
import library.service.AuthorService;
import library.service.BookService;
import library.service.PublisherService;
import library.to.BookTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditController {

    @Autowired
    private State state;

    @Autowired
    private BookService srv;

    @Autowired
    private PublisherService pService;

    @Autowired
    private AuthorService aServise;

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
        return "redirect:books.html";
    }

    /**
     * This method removes book by id and redirect to index
     *
     * @param id
     * @return
     */
    @GetMapping(value = "remove.html")
    public String delete(@RequestParam("id") final Long id) {
        srv.delete(id);
        return "redirect:books.html";
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

    @PostMapping(value = "authorsave.html")
    public String addAuthor(@RequestParam("name") String name, @RequestParam(required = false)@PathVariable("id") final Long id) {
        state.setAuthorId(id);
        state.setAuthorName(name);
        return "redirect:authorsave.html";
    }

    @GetMapping(value = "authorsave.html")
    public String addPublisher(final Model model) {
        aServise.save(new Author(state.getAuthorId(),state.getAuthorName()));
        model.addAttribute("publishers", pService.getAll());
        model.addAttribute("authors", aServise.getAll());
        return "addedit";
    }

    @PostMapping(value = "addpublisher.html")
    public String addPublisher(@RequestParam("name") String name) {
        Publisher publisher = new Publisher();
        if (state.getPublisherId() != null) {
            publisher.setId(state.getPublisherId());
            state.setPublisherId(null);
        }
        publisher.setName(name);
        pService.save(publisher);
        return "redirect:publishers.html";
    }

    @GetMapping(value = {"addpublisher.html", "editpublisher.html"})
    public String addPublisher(@RequestParam(required = false) @PathVariable("id") final Long id, final Model model) {
        model.addAttribute("publisher", pService.getById(id));
        state.setPublisherId(id);
        return "editPublisher";
    }

    @PostMapping(value = "authoredit.html")
    public String addAuthor(@RequestParam(required = false) @PathVariable("id") final Long id, final Model model) {
        model.addAttribute("author", aServise.getById(id));
        return "authoraddedit";
    }

    @Component
    @Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public static class State {

        private Long authorId;

        private String authorName;

        private Long publisherId;

        private String publisherName;

        public Long getAuthorId() {
            return authorId;
        }

        public void setAuthorId(Long authorId) {
            this.authorId = authorId;
        }

        public String getAuthorName() {
            return authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

        public Long getPublisherId() {
            return publisherId;
        }

        public void setPublisherId(Long publisherId) {
            this.publisherId = publisherId;
        }

        public String getPublisherName() {
            return publisherName;
        }

        public void setPublisherName(String publisherName) {
            this.publisherName = publisherName;
        }
    }
}
