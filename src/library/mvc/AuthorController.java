package library.mvc;

import library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
     * @param model
     * @return
     */
    @GetMapping(value = "authors.html")
    public String getAll(final Model model) {
        model.addAttribute("autors", service.getAll());
        return "allauthors";
    }

    /**
     * This method gets authors by ID, put them to model and view on editAuthors.jsp
     * @param model
     * @param id
     * @return
     */
    @GetMapping(value = "editauthors.html")
    public String edit(final Model model, @RequestParam("id") final  Long id){
        model.addAttribute("book", service.getById(id));
        return "redirect:editAuthors";
    }

}
