package library.mvc;

import library.entity.Author;
import library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author by Azarenka Anton
 */

@Controller
public class AuthorController {

    @Autowired
    private AuthorService service;

    /**
     * This method gets all authors, puts them to model and view on allAuthors.jsp
     *
     * @param model
     * @return
     */
    @GetMapping(value = "authors.html")
    public String getAll(final Model model) {
        model.addAttribute("authors", service.getAll());
        return "allauthors";
    }

    /**
     * This method gets authors by ID, put them to model and view on editAuthors.jsp
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping(value = "editauthors.html")
    public String edit(final Model model, @RequestParam("id") final Long id) {
        model.addAttribute("book", service.getById(id));
        return "editAuthors";
    }

    /**
     * This methos remove author by Id and redirect to allauthos.jsp
     *
     * @param id
     * @return
     */
    @PostMapping(value = "removeAuthors.html")
    public String delete(@RequestParam("id") final Long id) {
        service.delete(id);
        return "redirect:authors.html";
    }

    /**
     * This method gets authors by name, put them to model and redirect on author.jsp
     *
     * @param model
     * @param name
     * @return
     */
    @GetMapping(value = "getAuthorByName.html")
    public String getByName(final Model model, @RequestParam("name") final String name) {
        model.addAttribute("author", service.getByName(name));
        return "author";
    }

    /**
     * This method gets authors by ID, put them to model and redirect on author.jsp
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping(value = "getAuthorById.html")
    public String getById(final Model model, @RequestParam("id") final Long id) {
        model.addAttribute("author", service.getById(id));
        return "author";
    }

    /**
     * This method saves authors  and redirect on allAuthors.jsp
     *
     * @param id
     * @param name
     * @return
     */
    @PostMapping(value = "saveAuthor.html")
    public String save(@RequestParam(required = false) @PathVariable("id") final Long id,
                       @RequestParam("name") final String name) {
        service.save(new Author(id, name));
        return "redirect:allauthors";
    }

    @GetMapping(value = "authoredit.html")
    public String edit() {
        return "authoraddedit";
    }
}


